import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(27);
        arrayList.add(59);
        arrayList.add(41);
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(64);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(38);
        arrayList.add(7);
        arrayList.add(7);
        arrayList.add(69);
        arrayList.add(81);
        arrayList.add(26);
        arrayList.add(18);
        arrayList.add(75);
        arrayList.add(3);
        long countEvenNumbers = arrayList.stream() // 1) Определение количества четных чисел в потоке данных
                .filter((value) -> value % 2 == 0)
                .count();
        System.out.println("Count of even numbers: " + countEvenNumbers);
        List<Integer> newList = arrayList.stream() // 2) Сортировка по возрастанию
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println("Sort Asc: " + newList);
        List<Integer> newList2 = arrayList.stream()  // 2) Сортировка по убыванию
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList());
        System.out.println("Sort Desc: " + newList2);
        Optional<Integer> min = arrayList.stream()  // 3) Вывод минимального элемента
                .min((o1, o2) -> o1.compareTo(o2));
        min.ifPresent(minValue -> System.out.println("Min value: " + minValue));
        Optional<Integer> max = arrayList.stream()  // 3) Вывод максимального элемента
                .max((o1, o2) -> o1.compareTo(o2));
        max.ifPresent(maxValue -> System.out.println("Max value: " + maxValue));
        arrayList.stream()  // 4) Отфильтровать значения, условие -   > 20. Отсортировать их по возрастанию. Вывести значения умножив на 10
                .filter((value) -> value > 20)
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList())
                .forEach(value -> System.out.print(value * 10 + " "));
        System.out.println();
        Optional<Integer> maxFiveTask = arrayList.stream()  //  5) Пропустить 5 значений листа, задать лимит в 10 значений. Найти уникальные значения и определить среди них максимальное
                .skip(5)
                .limit(10)
                .distinct()
                .max((o1, o2) -> o1.compareTo(o2));
        maxFiveTask.ifPresent(maxValue -> System.out.println("Max value for 5 task: " + maxValue));
        System.out.println("6 task: ");               //  6) Пропустить 5 значений листа, задать лимит в 10 значений. Каждое число умножить на 10, отсортировать по убыванию, вывести значения, прибавив 5
        arrayList.stream()
                .skip(5)
                .limit(10)
                .map((value) -> (value * 10))
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList())
                .forEach((value) -> System.out.print(value + 5  + " "));
    }
}
