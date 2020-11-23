package sorts.select;

import main.ArrayVisualizer;
import sorts.templates.Sort;

final public class BaseNMaxHeapSort extends Sort {
    public BaseNMaxHeapSort(ArrayVisualizer arrayVisualizer) {
        super(arrayVisualizer);
        this.setSortListName("Base-N Max Heap");
        this.setRunAllSortsName("Base-N Max Heap Sort");
        this.setRunSortName("Base-N Max Heapsort");
        this.setCategory("Selection Sorts");
        this.setComparisonBased(true);
        this.setBucketSort(true);
        this.setRadixSort(false);
        this.setUnreasonablySlow(false);
        this.setUnreasonableLimit(0);
        this.setBogoSort(false);
    }

    private void siftDown(int[] arr, int base, int node, int stop) {
        int left = node * base + 1;
        if (left < stop) {
            int maxIndex = left;
            for (int i = left + 1; i < left + base; i++) {
                if (i >= stop)
                    break;
                if (Reads.compareValues(arr[maxIndex], arr[i]) == -1)
                    maxIndex = i;
            }
            if (Reads.compareValues(arr[node], arr[maxIndex]) == -1) {
                Writes.swap(arr, node, maxIndex, 1, true, false);
                this.siftDown(arr, base, maxIndex, stop);
            }
        }
    }

    @Override
    public void runSort(int[] arr, int length, int base) {
        for (int i = length - 1; i > -1; i--)
            this.siftDown(arr, base, i, length);
        for (int i = length - 1; i > 0; i--) {
            Writes.swap(arr, 0, i, 1, true, false);
            this.siftDown(arr, base, 0, i);
        }
    }
}