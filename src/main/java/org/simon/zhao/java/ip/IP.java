package org.simon.zhao.java.ip;

/**
 * Created by layne.jiang on 2016/11/16.
 */




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class IP {

    private static final Logger log = LoggerFactory.getLogger(IP.class);
    public static String randomIp() {
        Random r = new Random();
        StringBuffer str = new StringBuffer();
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(0);

        return str.toString();
    }

    public static void main(String[] args) throws InterruptedException {

        IP.load("data/mydata4vipday2.dat");

//       setAddr();
        log.info("180.0.235.255  {}", Arrays.toString(IP.find("180.0.235.255")));

//        test(ip2long("180.0.233.255"), ip2long("180.0.235.255"));


//        for (int i = 0; i < 1000000; i++)
//        {
//            IP.find(randomIp());
//        }

//        System.out.println(Arrays.toString(IP.find("118.28.8.8")));
//        Long et = System.currentTimeMillis();
//        System.out.println((et - st) );
//        int count = 1000000;
//        ExecutorService executors = Executors.newFixedThreadPool(100);
//
//        CountDownLatch countDownLatch = new CountDownLatch(count);
//        for(int i = 0;i<count;i++){
//            executors.execute(new Runnable() {
//                @Override
//                public void run() {
//                    IP.find(randomIp());
//                    countDownLatch.countDown();
//                }
//            });
//        }
//        countDownLatch.await();


    }

    public static boolean enableFileWatch = false;

    private static int offset;
    private static int[] index = new int[256];//第一个ip地址的偏移量
    private static ByteBuffer dataBuffer;
    private static ByteBuffer indexBuffer;
    private static Long lastModifyTime = 0L;
    private static File ipFile ;
    private static ReentrantLock lock = new ReentrantLock();

    public static void load(String filename) {
        ipFile = new File(filename);
        load();
        if (enableFileWatch) {
            watch();
        }
    }

    public static void load(String filename, boolean strict) throws Exception {
        ipFile = new File(filename);
        if (strict) {
            int contentLength = Long.valueOf(ipFile.length()).intValue();
            if (contentLength < 512 * 1024) {
                throw new Exception("ip data file error.");
            }
        }
        load();
        if (enableFileWatch) {
            watch();
        }
    }

    public static void setAddr()  {
//        String tt = "0.0.0.0";
//        long ttl = ip2long(tt);
//        int ip_prefix_value = new Integer(tt.substring(0, tt.indexOf(".")));
//        int start = index[ip_prefix_value];
        int max_comp_len = offset - 1028;

        byte b = 0;

        byte[] areaBytes;
        long count = 0;
        String fileName = "data/ip.txt";

        try (FileWriter fileWriter = new FileWriter("data/ip.txt");
                BufferedWriter bw = new BufferedWriter(fileWriter)){

            boolean flag = true;
            for (int i = 180; i < index.length && flag; i++) {
                int start = index[i];
                String startIp = i + ".0.0.0";
                for (start = start * 8 + 1024; start < max_comp_len; start += 8) {

                    count ++;
//                    System.out.printf("ip = %s \t index_offset = %d \t index_length = %d \t address = %s\n", ip, index_offset, index_length, Arrays.toString(find(ip)));
                    int ip = indexBuffer.getInt(start);
                    long index_offset = bytesToLong(b, indexBuffer.get(start + 6), indexBuffer.get(start + 5), indexBuffer.get(start + 4));
                    int index_length = 0xFF & indexBuffer.get(start + 7);
                    dataBuffer.position(offset + (int) index_offset - 1024);
                    areaBytes = new byte[index_length];
                    String ipStr = long2Ip(ip);
                    dataBuffer.get(areaBytes, 0, index_length);

                    String add[] = new String(areaBytes, Charset.forName("UTF-8")).split("\t", -1);
                    String line = startIp + "-" + ipStr + "\t" + Arrays.toString(add) + "\n";
                    long l = ip2long(ipStr);
                    startIp = long2Ip(ip2long(ipStr) +1);
                    bw.write(line);
//                    if(count > 2000) {
//                        flag = false;
//                        break;
//                    }
                    //            System.out.println(long2Ip(int2long(ip))+"--->"+ int2long(ip)+"--->" + Arrays.toString(add));
                    //            log.info(long2Ip(int2long(ip))+"--->"+ int2long(ip)+"--->" + Arrays.toString(add));
                    //            System.out.println(int2long(ip)+"--->"+Arrays.toString(add));

               /* if(int2long(ip) >= ttl){
                    System.out.println("终止 当前是"+ttl);
                    break;
                }*/
                }
            }

            System.out.println("count = " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static String[] find(String ip) {
        int ip_prefix_value = new Integer(ip.substring(0, ip.indexOf(".")));
        long ip2long_value  = ip2long(ip);
        int start = index[ip_prefix_value];
        int max_comp_len = offset - 1028;
        long index_offset = -1;
        int index_length = -1;
        byte b = 0;

        for (start = start * 8 + 1024; start < max_comp_len; start += 8) {
//            System.out.println(indexBuffer.getInt(start)+"-->"+ip2long_value);
            if (int2long(indexBuffer.getInt(start)) >= ip2long_value) {
                index_offset = bytesToLong(b, indexBuffer.get(start + 6), indexBuffer.get(start + 5), indexBuffer.get(start + 4));
                index_length = 0xFF & indexBuffer.get(start + 7);
                break;
            }
        }

        byte[] areaBytes;

        lock.lock();
        try {
            dataBuffer.position(offset + (int) index_offset - 1024);
            areaBytes = new byte[index_length];
            dataBuffer.get(areaBytes, 0, index_length);
        } finally {
            lock.unlock();
        }

        return new String(areaBytes, Charset.forName("UTF-8")).split("\t", -1);
    }

    private static void watch() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long time = ipFile.lastModified();
                if (time > lastModifyTime) {
                    lastModifyTime = time;
                    load();
                }
            }
        }, 1000L, 5000L, TimeUnit.MILLISECONDS);
    }

    private static void load() {
        lastModifyTime = ipFile.lastModified();
        FileInputStream fin = null;
        lock.lock();
        try {
            dataBuffer = ByteBuffer.allocate(Long.valueOf(ipFile.length()).intValue());
            fin = new FileInputStream(ipFile);
            int readBytesLength;
            byte[] chunk = new byte[4096];
            while (fin.available() > 0) {
                readBytesLength = fin.read(chunk);
                dataBuffer.put(chunk, 0, readBytesLength);
            }
            dataBuffer.position(0);
            int indexLength = dataBuffer.getInt();
            byte[] indexBytes = new byte[indexLength];
            dataBuffer.get(indexBytes, 0, indexLength - 4);
            indexBuffer = ByteBuffer.wrap(indexBytes);
            indexBuffer.order(ByteOrder.LITTLE_ENDIAN);
            offset = indexLength;

            int loop = 0;
            while (loop++ < 256) {
                index[loop - 1] = indexBuffer.getInt();
            }
            indexBuffer.order(ByteOrder.BIG_ENDIAN);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    private static long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }

    private static int str2Ip(String ip)  {
        String[] ss = ip.split("\\.");
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);

        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    private static long ip2long(String ip)  {
        return int2long(str2Ip(ip));
    }

    private static String long2Ip(long l) {
        String binStr = long2Bin(l);
        int[] nums = new int[4];
        String ip = "";
//        System.out.println(l + "---> " + binStr);
        for (int i = 0; i <  4; i ++) {
            String s = binStr.substring(8*i, (i+1)*8);
            nums[i] = Integer.valueOf(s, 2);
            ip = ip + nums[i] + ".";
        }
        return ip.substring(0, ip.length()-1);
    }

    private static String long2Bin(long lg) {
        String binStr = Long.toBinaryString(lg);
        while(binStr.length() < 32) {
             binStr = "0" + binStr;
        }
        return binStr;
    }

    private static long int2long(int i) {
        //7f会把ip地址的第一个地址修改为192最大
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }

    public static void test(long start, long end) {
        long index = start;
        while (index++ < end) {
            log.info(long2Ip(index)+"--->"+ index + "--->" + Arrays.toString(find(long2Ip(index))));
        }
    }
}
