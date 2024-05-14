package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        // implement the actual logic (remove next line)
        int[] searchedIndexes = new int[2];

        int low = 0;
        int high = entries.length - 1;

        int firstCount = 0;
        int singleMatch = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(searchableName.compareTo(entries[mid].getName())<0){
                high = mid - 1;
            }
            else if(searchableName.compareTo(entries[mid].getName())>0){
                low = mid + 1;
            }
            else{
                if(firstCount==0){
                    searchedIndexes[0] = mid;
                    firstCount++;
                    singleMatch++;
                }
                else {
                    searchedIndexes[1] = mid;
                    singleMatch++;
                }
                low = mid + 1;
            }
        }

        if(singleMatch==1){
            searchedIndexes[1] = searchedIndexes[0];
            return searchedIndexes;
        }
        else if(singleMatch==0){
            return new int[]{};
        }

        return searchedIndexes;
    }
}