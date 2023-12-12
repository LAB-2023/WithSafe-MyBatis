package com.withsafe.test;

import com.withsafe.domain.admin.dao.AdminRepository;
import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.admin.domain.Authority;
import com.withsafe.domain.beacon.dao.BeaconRepository;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.domain.BeaconType;
import com.withsafe.domain.bioData.dao.BioDataRepository;
import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.deviceSetting.dao.DeviceSettingRepository;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import com.withsafe.domain.env.dao.EnvNoticeRepository;
import com.withsafe.domain.env.dao.EnvSensorDataRepository;
import com.withsafe.domain.env.dao.EnvSensorRepository;
import com.withsafe.domain.env.domain.EnvNotice;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.domain.EnvSensorData;
import com.withsafe.domain.helmet.dao.HelmetRepository;
import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.outdoorMap.Repository.OutdoorMapRepository;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.outdoorUserLocation.domain.OutdoorUserLocation;
import com.withsafe.domain.outdoorUserLocation.repository.OutdoorUserLocationRepository;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import com.withsafe.domain.restrictArea.dao.RestrictAreaRepository;
import com.withsafe.domain.solve.dao.SolveRepository;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.Sex;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.domain.WatchData;
import com.withsafe.domain.watchData.repository.WatchDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class InsertDb {

    private final DepartmentRepository departmentRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final BioDataRepository bioDataRepository;
    private final HelmetRepository helmetRepository;
    private final WatchRepository watchRepository;
    private final WatchDataRepository watchDataRepository;
    private final WarningMessageRepository warningMessageRepository;
    private final NoticeRepository noticeRepository;
    private final SolveRepository solveRepository;
    private final DeviceSettingRepository deviceSettingRepository;
    private final OutdoorMapRepository outdoorMapRepository;
    private final EnvSensorRepository envSensorRepository;
    private final EnvNoticeRepository envNoticeRepository;
    private final EnvSensorDataRepository envSensorDataRepository;
    private final OutdoorUserLocationRepository outDoorUserLocationRepository;
    private final IndoorMapRepository indoorMapRepository;
    private final RestrictAreaRepository restrictAreaRepository;
    private final BeaconRepository beaconRepository;
    @Autowired
    public InsertDb(DepartmentRepository departmentRepository, AdminRepository adminRepository,
                    UserRepository userRepository, BioDataRepository bioDataRepository, HelmetRepository helmetRepository,
                    WatchRepository watchRepository, WatchDataRepository watchDataRepository,
                    WarningMessageRepository warningMessageRepository, NoticeRepository noticeRepository,
                    SolveRepository solveRepository, DeviceSettingRepository deviceSettingRepository,
                    OutdoorMapRepository outdoorMapRepository, EnvSensorRepository envSensorRepository,
                    EnvNoticeRepository envNoticeRepository, EnvSensorDataRepository envSensorDataRepository,
                    OutdoorUserLocationRepository outDoorUserLocationRepository, IndoorMapRepository indoorMapRepository,
                    RestrictAreaRepository restrictAreaRepository, BeaconRepository beaconRepository) {
        this.departmentRepository = departmentRepository;
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.bioDataRepository = bioDataRepository;
        this.helmetRepository = helmetRepository;
        this.watchRepository = watchRepository;
        this.watchDataRepository = watchDataRepository;
        this.warningMessageRepository = warningMessageRepository;
        this.noticeRepository = noticeRepository;
        this.solveRepository = solveRepository;
        this.deviceSettingRepository = deviceSettingRepository;
        this.outdoorMapRepository = outdoorMapRepository;
        this.envSensorRepository = envSensorRepository;
        this.envNoticeRepository = envNoticeRepository;
        this.envSensorDataRepository = envSensorDataRepository;
        this.outDoorUserLocationRepository = outDoorUserLocationRepository;
        this.indoorMapRepository = indoorMapRepository;
        this.restrictAreaRepository = restrictAreaRepository;
        this.beaconRepository = beaconRepository;
    }

    @Test
    public void Department넣기(){
        departmentRepository.save(makeDepartment("SBSystems"));
        departmentRepository.save(makeDepartment("A-Department"));
        departmentRepository.save(makeDepartment("B-Department"));
        departmentRepository.save(makeDepartment("C-Department"));
    }

    @Test
    public void Admin넣기(){
        Department department = departmentRepository.findByName("SBSystems").orElseThrow();
        Department department1 = departmentRepository.findByName("A-Department").orElseThrow();
        adminRepository.save(makeAdmin("User-A", Authority.ROLE_MASTER, "testId1", "testPwd1", department));
        adminRepository.save(makeAdmin("User-B", Authority.ROLE_SLAVE, "testId2", "testPwd2", department1));
    }

    @Test
    public void User넣기(){
        userRepository.save(makeUser(20, "test_ec", "test_er", 100, 100, "hi",
                10, "010-1234-1234", Sex.Male, 10, 10));
        userRepository.save(makeUser(22, "test_ec2", "test_er2", 100, 100, "hi2",
                10, "010-1234-1234", Sex.Male, 10, 10));
    }

    @Test
    public void BioData넣기(){
        User user = userRepository.findByName("hi").get(0);
        User user2 = userRepository.findByName("hi2").get(0);
        bioDataRepository.save(makeBioData(1, 2, false, 20, 20, 20, user));
        bioDataRepository.save(makeBioData(1, 2, false, 20, 20, 20, user2));
    }

    @Test
    public void Helmet넣기(){
        helmetRepository.save(makeHelmet(10L, true, "testModel", "testSerial"));
        helmetRepository.save(makeHelmet(11L, true, "testModel1", "testSerial1"));
    }

    @Test
    public void Watch넣기(){
        Helmet helmet = helmetRepository.findById(11L).orElseThrow();
        Helmet helmet1 = helmetRepository.findById(12L).orElseThrow();
        Department department = departmentRepository.findByName("A-Department").orElseThrow();
        User user = userRepository.findByName("hi").get(0);
        User user2 = userRepository.findByName("hi2").get(0);

        watchRepository.save(makeWatch(1, true, "testModel", "testSerial", department, helmet, user));
        watchRepository.save(makeWatch(2, true, "testModel2", "testSerial2", department, helmet1, user2));
    }

    @Test
    public void WatchData넣기(){
        Watch watch = watchRepository.findById(13L).orElseThrow();
        Watch watch1 = watchRepository.findById(14L).orElseThrow();

        watchDataRepository.save(makeWatchData("testBattery", "testCharge", watch));
        watchDataRepository.save(makeWatchData("testBattery2", "testCharge2", watch1));
    }

    @Test
    public void OutdoorUserLocation넣기(){
        Watch watch = watchRepository.findById(13L).orElseThrow();
        Watch watch1 = watchRepository.findById(14L).orElseThrow();

        outDoorUserLocationRepository.save(makeOutdoorUserLocation(watch));
        outDoorUserLocationRepository.save(makeOutdoorUserLocation(watch1));
    }

    @Test
    public void WarningMessage넣기(){
        Department department = departmentRepository.findByName("SBSystems").orElseThrow();
        Department department1 = departmentRepository.findByName("A-Department").orElseThrow();

        warningMessageRepository.save(makeWarningMessage("testWarningMessage", WarningMessageType.HEART, department));
        warningMessageRepository.save(makeWarningMessage("testWarningMessage2", WarningMessageType.DANGER_ZONE, department1));
    }

    @Test
    public void Notice넣기(){
        WarningMessage warningMessage = warningMessageRepository.findById(19L).orElseThrow();
        WarningMessage warningMessage2 = warningMessageRepository.findById(20L).orElseThrow();

        Watch watch = watchRepository.findById(13L).orElseThrow();
        Watch watch1 = watchRepository.findById(14L).orElseThrow();

        noticeRepository.save(makeNotice("testNotice", NoticeType.HEART, warningMessage, watch));
        noticeRepository.save(makeNotice("testNotice2", NoticeType.ENV, warningMessage, watch1));
        noticeRepository.save(makeNotice("testNotice3", NoticeType.SOS, warningMessage2, watch));
        noticeRepository.save(makeNotice("testNotice4", NoticeType.WARNING, warningMessage2, watch1));
    }

    @Test
    public void Solve넣기(){
        Notice notice = noticeRepository.findById(21L).orElseThrow();
        Notice notice1 = noticeRepository.findById(22L).orElseThrow();
        Notice notice2 = noticeRepository.findById(23L).orElseThrow();

        solveRepository.save(makeSolve("testSolveContent", notice));
        solveRepository.save(makeSolve("testSolveContent2", notice1));
        solveRepository.save(makeSolve("testSolveContent3", notice2));
    }

    @Test
    public void DeviceSetting넣기(){
        deviceSettingRepository.save(makeDeviceSetting(1, 1, "testType", "testType", "testType", 1, 1,1 ,1 ,
                1, 1, 1, 1, 1, 1));
        deviceSettingRepository.save(makeDeviceSetting(2, 2, "testType2", "testType2", "testType2", 2, 2,2 ,2,
                2, 2, 2, 2, 2, 2));
    }

    @Test
    public void Outdoormap넣기(){
        Department department = departmentRepository.findByName("SBSystems").orElseThrow();
        Department department1 = departmentRepository.findByName("A-Department").orElseThrow();

        outdoorMapRepository.save(makeOutdoorMap("testOutdoorMap", department));
        outdoorMapRepository.save(makeOutdoorMap("testOutdoorMap2", department1));
    }

    @Test
    public void EnvSensor넣기(){
        OutdoorMap outdoorMap = outdoorMapRepository.findById(30L).orElseThrow();
        OutdoorMap outdoorMap1 = outdoorMapRepository.findById(31L).orElseThrow();

        envSensorRepository.save(makeEnvSensor(true, "testModel", "testSerialNum", outdoorMap));
        envSensorRepository.save(makeEnvSensor(true, "testModel2", "testSerialNum2", outdoorMap1));
    }

    @Test
    public void EnvNotice넣기(){
        EnvSensor envSensor = envSensorRepository.findById(32L).orElseThrow();
        EnvSensor envSensor2 = envSensorRepository.findById(33L).orElseThrow();

        envNoticeRepository.save(makeEnvNotice(envSensor));
        envNoticeRepository.save(makeEnvNotice(envSensor2));
    }

    @Test
    public void EnvSensorData넣기(){
        EnvSensor envSensor = envSensorRepository.findById(32L).orElseThrow();
        EnvSensor envSensor2 = envSensorRepository.findById(33L).orElseThrow();

        envSensorDataRepository.save(makeEnvSensorData("testCode", "testDevice", "testName", 1.0f, envSensor));
        envSensorDataRepository.save(makeEnvSensorData("testCode2", "testDevice2", "testName2", 2.0f, envSensor2));
    }

    @Test
    public void IndoorMap넣기(){
        Department department = departmentRepository.findByName("SBSystems").orElseThrow();
        Department department1 = departmentRepository.findByName("A-Department").orElseThrow();

        indoorMapRepository.save(makeIndoorMap("testImage", "testName", department));
        indoorMapRepository.save(makeIndoorMap("testImage2", "testName2", department1));
    }

    @Test
    public void RestrictArea넣기(){
        OutdoorMap outdoorMap = outdoorMapRepository.findById(30L).orElseThrow();
        OutdoorMap outdoorMap1 = outdoorMapRepository.findById(31L).orElseThrow();

        IndoorMap indoorMap = indoorMapRepository.findById(38L).orElseThrow();
        IndoorMap indoorMap1 = indoorMapRepository.findById(39L).orElseThrow();

        restrictAreaRepository.save(makeRestrictArea("testName", "testRule", null, outdoorMap));
        restrictAreaRepository.save(makeRestrictArea("testName2", "testRule2", null, outdoorMap1));
        restrictAreaRepository.save(makeRestrictArea("testName3", "testRule3", indoorMap, null));
        restrictAreaRepository.save(makeRestrictArea("testName4", "testRule4", indoorMap1, null));
    }

    @Test
    public void Beacon넣기(){
        IndoorMap indoorMap = indoorMapRepository.findById(38L).orElseThrow();
        IndoorMap indoorMap1 = indoorMapRepository.findById(39L).orElseThrow();

        beaconRepository.save(makeBeacon(BeaconType.SAFE, "testAddress", "testStatus", indoorMap));
        beaconRepository.save(makeBeacon(BeaconType.DANGER, "testAddress2", "testStatus2", indoorMap1));
    }

    @Test
    public void IndoorEntrance넣기(){
//        Beacon beacon = beaconRepository.findById(42L).orElseThrow();
//        Beacon beacon1 = beaconRepository.findById(43L).orElseThrow();
//
//        Watch watch = watchRepository.findById(11L).orElseThrow();
//        Watch watch1 = watchRepository.findById(12L).orElseThrow();
//
//        test.save(makeIndoorEntrance(beacon, watch));
//        test.save(makeIndoorEntrance(beacon1, watch1));
    }

    private Department makeDepartment(String name){
        return Department.builder().name(name).build();
    }

    private Admin makeAdmin(String name, Authority authority, String login_id, String loginPassword, Department department){
        return Admin.builder().name(name).authority(authority).loginId(login_id).loginPassword(loginPassword).department(department).build();
    }

    private User makeUser(int age, String ec, String er, int hr, double height, String name, int ot,
                          String pn, Sex sex, int wt, double we){
        return User.builder().age(age).emergency_contact(ec).emergency_relation(er).heartRate_threshold(hr)
                .height(height).name(name).oxygen_threshold(ot).phoneNum(pn).sex(sex).walk_threshold(wt).weight(we).build();
    }

    private BioData makeBioData(int c, int hr, boolean iF, double ox, double tm, int wc, User user){
        return BioData.builder().calorie(c).heartRate(hr).isFall(iF).oxygen(ox).temperature(tm).walkCount(wc).user(user).build();
    }

    private Helmet makeHelmet(Long dn, Boolean iu, String model, String sn){
        return Helmet.builder().deviceNum(dn).is_used(iu).model(model).serialNum(sn).build();
    }

    private Watch makeWatch(int dn, Boolean is, String model, String serial, Department department, Helmet helmet, User user){
        return Watch.builder().deviceNum(dn).is_used(is).model(model)
                .serialNum(serial).department(department).helmet(helmet).user(user).build();
    }

    private WatchData makeWatchData(String battery, String charge, Watch watch){
        return WatchData.builder().battery(battery).charge(charge).watch(watch).build();
    }

    private OutdoorUserLocation makeOutdoorUserLocation(Watch watch){
        return OutdoorUserLocation.builder().watch(watch).build();
    }

    private WarningMessage makeWarningMessage(String content, WarningMessageType warningMessageType, Department department){
        return WarningMessage.builder().content(content).type(warningMessageType).department(department).build();
    }

    private Notice makeNotice(String content, NoticeType noticeType, WarningMessage warningMessage, Watch watch){
        return Notice.builder().content(content).noticeType(noticeType).warning_message(warningMessage).watch(watch).build();
    }

    private Solve makeSolve(String content, Notice notice){
        return Solve.builder().content(content).notice(notice).build();
    }

    private DeviceSetting makeDeviceSetting(int bu, int bs, String bft, String bfv, String bst,
                                            int bsv, int bleu, int cu, int gs, int gu, int hrmax,
                                            int hrmin, int su, int sensor_u, int wu){
        return DeviceSetting.builder().battery_upload(bu).bio_store(bs).ble_filter_type(bft).ble_filter_value(bfv)
                .ble_scan_type(bst).ble_scan_value(bsv).ble_upload(bleu).charge_upload(cu).gps_store(gs)
                .gps_upload(gu).heart_rate_max(hrmax).heart_rate_min(hrmin).safe_upload(su).sensor_upload(sensor_u)
                .warning_upload(wu).build();
    }

    private OutdoorMap makeOutdoorMap(String name, Department department){
        return OutdoorMap.builder().name(name).department(department).build();
    }

    private EnvSensor makeEnvSensor(Boolean is, String model, String serial_num, OutdoorMap outdoorMap){
        return EnvSensor.builder().isUsed(is).model(model).serialNum(serial_num).outdoorMap(outdoorMap).build();
    }

    private EnvNotice makeEnvNotice(EnvSensor envSensor){
        return EnvNotice.builder().envSensor(envSensor).build();
    }

    private EnvSensorData makeEnvSensorData(String ac, String device, String name, float version, EnvSensor envSensor){
        return EnvSensorData.builder().assetCode(ac).device(device).name(name).version(version).envSensor(envSensor).build();
    }

    private IndoorMap makeIndoorMap(String image, String name, Department department){
        return IndoorMap.builder().imageUrl(image).name(name).department(department).build();
    }

    private RestrictArea makeRestrictArea(String name, String rule, IndoorMap indoorMap, OutdoorMap outdoorMap){
        return RestrictArea.builder().name(name).safetyRule(rule).indoorMap(indoorMap).outdoorMap(outdoorMap).build();
    }

    private Beacon makeBeacon(BeaconType beaconType, String address, String status, IndoorMap indoorMap){
        return Beacon.builder().beaconType(beaconType).macAddress(address).status(status).indoorMap(indoorMap).build();
    }

    private IndoorEntrance makeIndoorEntrance(Beacon beacon, Watch watch){
        return IndoorEntrance.builder().beacon(beacon).watch(watch).build();
    }
}
