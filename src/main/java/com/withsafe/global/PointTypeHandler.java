package com.withsafe.global;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;

import java.sql.*;

@MappedTypes(Point.class)
@MappedJdbcTypes(JdbcType.OTHER)
public class PointTypeHandler implements TypeHandler<Point> {
    private static final GeometryFactory geometryFactory = new GeometryFactory();
    private static final WKBReader wkbReader = new WKBReader();

    @Override
    public void setParameter(PreparedStatement ps, int i, Point parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setNull(i, Types.OTHER);
        } else {
            // Point 객체를 WKB (Well-Known Binary) 형식으로 변환
            WKBWriter writer = new WKBWriter();
            byte[] wkb = writer.write(parameter);
            ps.setObject(i, wkb);
        }
    }

    @Override
    public Point getResult(ResultSet rs, String columnName) throws SQLException {
        byte[] wkb = rs.getBytes(columnName);
        return parseWKBToPoint(wkb);
    }

    @Override
    public Point getResult(ResultSet rs, int columnIndex) throws SQLException {
        byte[] wkb = rs.getBytes(columnIndex);
        return parseWKBToPoint(wkb);
    }

    @Override
    public Point getResult(CallableStatement cs, int columnIndex) throws SQLException {
        byte[] wkb = cs.getBytes(columnIndex);
        return parseWKBToPoint(wkb);
    }

    private Point parseWKBToPoint(byte[] wkb) {
        if (wkb != null) {
            try {
                // WKB 데이터를 파싱하여 Geometry 객체로 변환
                Geometry geometry = new WKBReader().read(wkb);
                // SRID를 4326으로 설정
                geometry.setSRID(4326);
                if (geometry instanceof Point) {
                    return (Point) geometry;
                } else {
                    // 다른 Geometry 유형을 처리하거나 예외를 발생시킬 수 있습니다.
                    // 여기서는 예외를 발생시키지 않고 null을 반환합니다.
                    return null;
                }
            } catch (ParseException e) {
                throw new RuntimeException("Failed to parse WKB to Point", e);
            }
        }
        return null;
    }
}