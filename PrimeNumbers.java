public class PrimeNumbers {
    
    // 判断一个数是否为素数 - 基础版本（最费时）
    public static boolean isPrimeBasic(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 改进版本：检查到sqrt(n)即可
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        // 只需要检查到sqrt(n)
        int limit = (int)Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 进一步优化：使用6k±1规则
    public static boolean isPrimeBest(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        // 检查6k±1形式的因子
        int limit = (int)Math.sqrt(n);
        for (int i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int count = 0;
        int totalPrimes = 0;
        
        System.out.println("1~20000内的素数:");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 2; i <= 20000; i++) {
            // 使用最优算法
            if (isPrimeBest(i)) {
                System.out.printf("%-6d", i);
                count++;
                totalPrimes++;
                
                if (count == 5) {
                    System.out.println();
                    count = 0;
                }
            }
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("\n\n总共找到 " + totalPrimes + " 个素数");
        System.out.println("计算耗时: " + (endTime - startTime) + " 毫秒");
        
        // 性能对比测试
        System.out.println("\n--- 性能对比 ---");
        
        // 测试基础版本
        long start1 = System.currentTimeMillis();
        int count1 = 0;
        for (int i = 2; i <= 20000; i++) {
            if (isPrimeBasic(i)) count1++;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("基础版本: " + (end1 - start1) + " 毫秒");
        
        // 测试优化版本
        long start2 = System.currentTimeMillis();
        int count2 = 0;
        for (int i = 2; i <= 20000; i++) {
            if (isPrimeOptimized(i)) count2++;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("优化版本: " + (end2 - start2) + " 毫秒");
        
        // 测试最优版本
        long start3 = System.currentTimeMillis();
        int count3 = 0;
        for (int i = 2; i <= 20000; i++) {
            if (isPrimeBest(i)) count3++;
        }
        long end3 = System.currentTimeMillis();
        System.out.println("最优版本: " + (end3 - start3) + " 毫秒");
    }
}