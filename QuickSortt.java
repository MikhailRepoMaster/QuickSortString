import java.util.Random;

public class QuickSortt
{
    private static int count = 0;

    public static void main(String[] args)
    {
        // int size = 10;
        // String[] arr = LengthArray(size);
        String[] arr = {"A","B","D","C","D","E","F","G"}; // Выдаёт 18 свапов
        // String[] arr = {"G","F","E","D","C","B","A"}; // Выдаёт 10 свапов
        // String[] arr = {"E","D","A","B","C","F","G"}; // Выдаёт 16 свапов
        System.out.println("Начальный массив: ");
        PrintArray(arr);

        QuickSort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив: ");
        PrintArray(arr);
        System.out.println("Количество свапов: " + count);
    }

    public static void QuickSort(String[] arr, int l, int r)
    {
        int i = l, j = r;
        String pivot = arr[(l + r) / 2];
        while (i <= j)
        {
            while (arr[i].compareTo(pivot) < 0)
            {
                i++;
                count++; 
            }
            while (arr[j].compareTo(pivot) > 0)
            {
                j--;
                count++; 
            }
            if (i <= j)
            {
                Swap(arr, i, j);
                count++; 
                i++;
                j--;
            }
        }

        if (l < j)
        {
            QuickSort(arr, l, j);
        }
        if (i < r)
        {
            QuickSort(arr, i, r);
        }
    }

    private static void Swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String[] LengthArray(int size)
    {
        Random random = new Random();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = Random(random, 1); // тут поменять если хотите не 1 символ, а 2 или 5
        }
        return arr;
    }

    private static String Random(Random random, int length)
    {
        StringBuilder seniorita = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            char c = (char) ('a' + random.nextInt(20)); // тут кол-во букв
            seniorita.append(c);
        }
        return seniorita.toString();
    }

    private static void PrintArray(String[] arr)
    {
        for (String str : arr) // str : arr это если что foreach
        {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
