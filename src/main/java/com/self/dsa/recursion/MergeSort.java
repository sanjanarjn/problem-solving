public class MergeSort {
	
	public static void mergeSort(int[] input){
		
        int[] sorted = mergeSort(input, 0, input.length - 1);
    	for(int i = 0; i < input.length; i++) {
            input[i] = sorted[i];
        }
    }
    
    public static int[] mergeSort(int[] input, int si, int ei) {
        
        if( si > ei)
            return new int[0];
        
        if(si == ei) {
            int[] sorted = new int[1];
            sorted[0] = input[si];
            return sorted;
        }
       
        
        int mid = (si + ei)/2;
        int[] a = mergeSort(input, si, mid);
        int[] b = mergeSort(input, mid + 1, ei);
        
        int[] sorted = merge(a, b);
        return sorted;
    }
    
     public static int[] merge(int[] a, int[] b) {
         
         int i = 0;
         int j = 0;
         
         int[] c = new int[a.length + b.length];
         
         int k = 0;
         while(i < a.length && j < b.length) {
             
             if(a[i] < b[j]) {
                 c[k] = a[i];
                 i++;
             }
             else {
                 c[k] = b[j];
                 j++;
             }
             k++;
         }
         while (i < a.length) {
             c[k++] = a[i++];
         }
         while (j < b.length) {
             c[k++] = b[j++];
         }
         return c;
     }

	
}

