package week3.labTask;

import java.io.File;
import java.io.FileNotFoundException;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) throws FileNotFoundException {
        //Getting w,x,y,z parts first, then making them into a IPNumber
        String[] ipAddressesStartEnd = new String[4];
        ipAddressesStartEnd = ipAddress.split("\\.");
        long w = Long.parseLong(ipAddressesStartEnd[0]);
        long x = Long.parseLong(ipAddressesStartEnd[1]);
        long y = Long.parseLong(ipAddressesStartEnd[2]);
        long z = Long.parseLong(ipAddressesStartEnd[3]);

        //Getting the IPNumber
        long ipNumber = (16777216L * w) + (65536L * x) + (256L * y) + z;
        int sizeOfArray = ipAddresses.length;

        //Searching for the IP address with binary search
        int low = 0;
        int high = sizeOfArray - 1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(ipNumber>ipAddresses[mid].getEndIp()){
                low = mid + 1;
            }
            else if(ipNumber<ipAddresses[mid].getStartIp()){
                high = mid - 1;
            }
            else{
                return ipAddresses[mid];
            }
        }
        return null;
    }
}
