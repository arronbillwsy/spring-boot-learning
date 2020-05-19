package learn_spring_boot.demo.util;

import cn.hutool.core.util.NumberUtil;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/5/9 10:22
 **/
public class ServerUtil {
    private static final int OSHI_WAIT_SECOND = 1000;

    public Map<String, Object> getCpuInfo(CentralProcessor processor) {
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(OSHI_WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        Map<String, Object> cpu = new HashMap<>();
        cpu.put("CPU Core Num", processor.getLogicalProcessorCount()); //cpu 核数
        cpu.put("CPU Usage",  NumberUtil.round(NumberUtil.mul(totalCpu, 100), 2).doubleValue()); // cpu总使用率
        cpu.put("CPU System Usage", NumberUtil.round(NumberUtil.mul(cSys/totalCpu, 100), 2).doubleValue()); // cpu系统使用率
        cpu.put("CPU User Usage", NumberUtil.round(NumberUtil.mul(user/totalCpu, 100), 2).doubleValue()); // cpu用户使用率
        cpu.put("CPU Wait", NumberUtil.round(NumberUtil.mul(idle/totalCpu, 100), 2).doubleValue()); // cpu当前等待率
        return cpu;
    }

    public Map<String, Object> getMemInfo(GlobalMemory memory) {
        Map<String, Object> mem = new HashMap<>();
        mem.put("Mem Total", NumberUtil.div(memory.getTotal(), (1024 * 1024 * 1024), 2)); // 总内存
        mem.put("Mem Used", NumberUtil.div(memory.getTotal() - memory.getAvailable(), (1024 * 1024 * 1024), 2)); // 已用内存
        mem.put("Mem Free", NumberUtil.div(memory.getAvailable(), (1024 * 1024 * 1024), 2)); // 剩余内存
        return mem;
    }

    public Map<String, Object> getSysInfo() throws UnknownHostException {
        Properties properties = System.getProperties();
        Map<String, Object> sys = new HashMap<>();
        sys.put("Computer Name", InetAddress.getLocalHost().getHostName()); // 服务器名称
        sys.put("Computer IP", InetAddress.getLocalHost().getHostAddress()); // 服务器IP
        sys.put("Os Name", properties.getProperty("os.name")); // 操作系统
        sys.put("Os Arch", properties.getProperty("os.arch")); // 系统架构
        sys.put("User Dir", properties.getProperty("user.dir")); // 项目路径
        return sys;
    }

    public Map<String, Object> getJvmInfo() {
        Properties properties = System.getProperties();
        Map<String, Object> jvm = new HashMap<>();
        jvm.put("JVM Total Mem", NumberUtil.div(Runtime.getRuntime().totalMemory(), (1024 * 1024), 2)); // 当前JVM占用总内存
        jvm.put("JVM Max Mem", NumberUtil.div(Runtime.getRuntime().maxMemory(), (1024 * 1024), 2)); // JVM最大可用内存
        jvm.put("JVM Free Mem", NumberUtil.div(Runtime.getRuntime().freeMemory(), (1024 * 1024), 2)); // JVM空闲内存
        jvm.put("JDK Version", properties.getProperty("java.version")); // JDK版本
        jvm.put("JDK Home", properties.getProperty("java.home")); // JDK路径
        return jvm;
    }

    public Map<String, Object> getSysFilesInfo(OperatingSystem operatingSystem) {
        Map<String, Object> sysFiles = new HashMap<>();
        FileSystem fileSystem = operatingSystem.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs: fsArray) {
            long free = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            long used = total - free;
            sysFiles.put("Dir Name", fs.getMount()); // 磁盘路径
            sysFiles.put("Dir Type", fs.getType()); // 磁盘类型
            sysFiles.put("File Type", fs.getName()); // 文件类型
            sysFiles.put("Dir Total Size", convertFileSize(total)); // 磁盘总量
            sysFiles.put("Dir Free Size", convertFileSize(free)); // 磁盘剩余
            sysFiles.put("Dir Used Size", convertFileSize(used)); // 磁盘已用
            sysFiles.put("Dir Usage", NumberUtil.mul(NumberUtil.div(used, total, 4), 100)); // 资源使用率
        }
        return sysFiles;
    }

    public String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}
