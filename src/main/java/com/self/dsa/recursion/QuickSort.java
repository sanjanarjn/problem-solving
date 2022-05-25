public static void quickSort(int[] input) {

        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] a, int si, int ei) {

        if(si >= ei) {
            return;
        }

        int pI = partition(a, si, ei);
        quickSort(a, si, pI - 1);
        quickSort(a, pI + 1, ei);
    }

    public static int partition(int a[], int si, int ei) {

        int pivotIndex = si;
        int pivot = a[pivotIndex];

        int i = si;
        for(int j = si + 1; j <= ei; j++) {
            if(a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i, pivotIndex);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
