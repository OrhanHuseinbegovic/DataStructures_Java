package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        // implement the actual logic (remove next line)
        int firstIndex = findFirstOccurrence(entries,searchableName);
        int lastIndex = findLastOccurrence(entries, searchableName);

        if(firstIndex == -1){
            return new int[]{};
        }
        else{
            return new int[]{firstIndex, lastIndex};
        }
    }

    private static int findFirstOccurrence(Entry[] entries, String searchableName){
        int low = 0;
        int high = entries.length-1;
        int result = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(searchableName.compareTo(entries[mid].getName())<0){
                high = mid - 1;
            }
            else if(searchableName.compareTo(entries[mid].getName())>0){
                low = mid + 1;
            }
            else{
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(Entry[] entries, String searchableName){
        int low = 0;
        int high = entries.length-1;
        int result = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(searchableName.compareTo(entries[mid].getName())<0){
                high = mid - 1;
            }
            else if(searchableName.compareTo(entries[mid].getName())>0){
                low = mid + 1;
            }
            else{
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }
}