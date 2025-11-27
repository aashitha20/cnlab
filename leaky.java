import java.util.Scanner;

public class leaky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter bucket size: ");
        int bucketSize = sc.nextInt();
        
        System.out.print("Enter output rate: ");
        int outputRate = sc.nextInt();
        
        System.out.print("Enter number of queries: ");
        int numQueries = sc.nextInt();
        
        int currentBucket = 0;
        
        for (int i = 1; i <= numQueries; i++) {
            System.out.print("\nEnter packet size for query " + i + ": ");
            int packetSize = sc.nextInt();
            
            System.out.println("\n--- Query " + i + " ---");
            System.out.println("Packet size: " + packetSize);
            
            if (packetSize > bucketSize) {
                System.out.println("Packet size exceeds bucket capacity. Packet rejected.");
                continue;
            }
            
            if (currentBucket + packetSize <= bucketSize) {
                currentBucket += packetSize;
                System.out.println("Packet accepted.");
            } else {
                System.out.println("Bucket overflow. Packet rejected.");
            }
            
            System.out.println("Bucket level before output: " + currentBucket);
            
            // Leak from bucket
            int leaked = Math.min(currentBucket, outputRate);
            currentBucket -= leaked;
            
            System.out.println("Packets transmitted: " + leaked);
            System.out.println("Bucket level after output: " + currentBucket);
        }
        
        sc.close();
    }
}
