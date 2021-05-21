package src.com.anton;

import src.com.anton.ClassPlayer.Warior;
import src.com.anton.Inventory.Armor;
import src.com.anton.Inventory.Weapon;
import src.com.anton.Routine.DataInput;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayerInitialized {
    static int bonuspoint = 15;
    static int number = 0;
    static int[] temp = new int[]{10, 10, 10, 10, 10, 10};

    public static <E extends Player> E Initial() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name = scanner.nextLine();
        System.out.println("Выберите класс персонажа из списка: Воин");
        do {
            String classname = scanner.nextLine();
            if (classname.equalsIgnoreCase("Воин")) {
                do {
                    System.out.println("Выбрать характеристики созданного персонажа (1) или из сохранённого (2)");
                    int start = DataInput.InputInteger();
                    if (start == 1) {
                        int[] character = PlayerInitialized.character();
                        Warior men = new Warior(name, "Воин", character[0], character[1], character[2], character[3], character[4],
                                character[5]);
                        return (E) men;
                    } else if (start == 2) {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\main\\resources\\PersonCharact.bin"));
                        int[] character2 = (int[]) ois.readObject();
                        Warior men = new Warior(name, "Воин", character2[0], character2[1], character2[2], character2[3], character2[4],
                                character2[5]);
                        ois.close();
                        return (E) men;
                    } else {
                        System.out.println("Неверное значение введите ещё раз");
                    }
                } while (true);
            } else {
                System.out.println("Неверный класс");
            }
        } while (true);
    }

    public static int[] character() throws IOException {
        boolean end;
        System.out.println("У вас есть лишних " + bonuspoint + " очков, по умолчанию все характеристики равны " +
                "10 вы вольны изменить их согласно таблице, но не меньше 7 и не больше 18");
        tablCharacter();
        //tempVizual(temp);
        start:
        do {
            int number2 = 0;
            System.out.println("Выберите характеристику для изменения:" + "\nБонусных очков для изменения:" + bonuspoint +
                    "\n1.Сила-" + temp[0] + "\n2.Ловкость-" + temp[1] + "\n3.Выносливость-" + temp[2] +
                    "\n4.Интеллект-" + temp[3] + "\n5.Мудрость-" + temp[4] + "\n6.Харизма-" + temp[5] +
                    "\n7.Таблица изменения характеристик" + "\n8.Сохранить" + "\n9.Выход");
            end = true;
            number = DataInput.InputInteger();
            if (number == 7) {
                tablCharacter();
                continue;
            }
            if (number == 8) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java\\PathFinderMaven\\src\\main\\resources\\PersonCharact.bin"));
                oos.writeObject(temp);
                oos.close();
                continue;
            }
            if (number == 9) {
                break;
            }
            if ((number < 1) || (number > 8)) {
                System.out.println("Число не в диапазоне 1-8");
                continue;
            }
            System.out.println("Введите новое значение");
            number2 = DataInput.InputInteger();
            if (number2 < 7 || number2 > 18) {
                System.out.println("Неверное значение. Введённое число должно быть в диапазоне 7-18");
                continue;
            }

            changeCharacter(number, number2, temp);

        } while (end);

        return temp;
    }

    private static void tempVizual(int[] temp) {
        System.out.printf("1.Сила:          %-2d\n" +
                "2.Ловкость:      %-2d\n" +
                "3.Выносливость:  %-2d\n" +
                "4.Интеллект:     %-2d\n" +
                "5.Мудрость:      %-2d\n" +
                "6.Харизма:       %-2d\n", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
    }

    private static void tablCharacter() {
        System.out.println("   Значение     |    Стоимость   ||   Значение     |    Стоимость   ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("       7        |        -4      ||       13       |         3      ");
        System.out.println("       8        |        -2      ||       14       |         5      ");
        System.out.println("       9        |        -1      ||       15       |         7      ");
        System.out.println("       10       |         0      ||       16       |        10      ");
        System.out.println("       11       |         1      ||       17       |        13      ");
        System.out.println("       12       |         2      ||       18       |        17      ");
    }

    private static void changeCharacter(int number1, int number2, int[] temp) {
        int tempchange = 0;
        Map<Integer, Integer> keyValue = new HashMap<>();
        keyValue.put(7, -4);
        keyValue.put(8, -2);
        keyValue.put(9, -1);
        keyValue.put(10, 0);
        keyValue.put(11, 1);
        keyValue.put(12, 2);
        keyValue.put(13, 3);
        keyValue.put(14, 5);
        keyValue.put(15, 7);
        keyValue.put(16, 10);
        keyValue.put(17, 13);
        keyValue.put(18, 17);
        tempchange = keyValue.get(temp[number1 - 1]) - keyValue.get(number2);
        if (Math.abs(tempchange) > bonuspoint) {
            System.out.println("Число выходит за пределы границ попробуйте снова");
        } else {
            bonuspoint += tempchange;
            temp[number1 - 1] = number2;
        }
    }

    private static Player createdCharacters() {
        return null;
    }

    public static void PartyInitial(List<Player> party) throws IOException, ClassNotFoundException {
        int count;
        System.out.println("Укажите размер отряда максимум 4 участника, при выборе 5 будет представлена заговленная пати на 4 участника");
        count=DataInput.InputInteger(5);
        if (count==5){
            party.add(new Warior("Вася", "Воин",18,15,10,10,8,7));
            party.add(new Warior("Ваня", "Воин",18,13,12,10,8,7));
            party.add(new Warior("Лёша", "Воин",18,12,11,10,8,7));
            party.add(new Warior("Сергей", "Воин",16,12,15,10,8,7));
        }else for(int i=0;i<count;i++){
            party.add(Initial());
        }
        party.get(0).setWeaponequepleft(new Weapon("Лёгкая булава", 12000, 4, "Одноручное", 1,
                6, 20,0));
        party.get(0).setWeaponequepright(new Weapon("Лёгкая булава", 12000, 4, "Одноручное", 1,
                6, 20,0));
        party.get(0).setArmorequep(new Armor("Сыромятный доспех", 15000, 25, "Средний", 1,
                 4,4,-3));
        party.get(1).setWeaponequepright(new Weapon("Длинное копье", 8000, 6, "Двуручное", 1,
                8, 20,0));
        party.get(1).setArmorequep(new Armor("Стёганный доспех", 500, 10, "Лёгкий", 1,
                1,8,0));
        party.get(2).setWeaponequepleft(new Armor("Баклер", 500, 5, "Щит", 1,
                1,0,-1));
        party.get(2).setWeaponequepright(new Weapon("Рапира", 20000, 2, "Полуторное", 1,
                6, 18,0));
        party.get(2).setArmorequep(new Armor("Баклер", 500, 5, "Щит", 1,
                1,0,-1));
        party.get(3).setWeaponequepleft(new Weapon("Лёгкая булава", 12000, 4, "Одноручное", 1,
                6, 20,0));
        party.get(3).setWeaponequepright(new Weapon("Серп", 6000, 2, "Одноручное", 1,
                6, 20,0));
        party.get(3).setArmorequep(new Armor("Сыромятный доспех", 15000, 25, "Средний", 1,
                4,4,-3));
    }


}
