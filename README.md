# Утилита фильтрации содержимого файлов

## Описание

Утилита предназначена для фильтрации содержимого файлов, содержащих целые числа, вещественные числа и строки. Программа разделяет данные по типам и записывает их в соответствующие файлы. Также поддерживается сбор статистики по данным.

---

## Требования

- **Java**: Версия 17 или выше.
- **Система сборки**: Maven 4.0.0 или выше.

---

## Сборка проекта

1. Клонируйте репозиторий:
      ```bash
      git clone https://github.com/Lobanovs/ShiftTest.git
      cd ShiftTest
      ```

2. Соберите проект с помощью Maven:
      ```bash
      mvn clean package
      ```
После успешной сборки в папке `target` будет создан файл `TestShift.jar`.

---

## Запуск утилиты

### Основной синтаксис
  ```bash
  java -jar TestShift.jar [опции] файл1 файл2 ...
  ```
### Опции
- `-o <путь>`: Указать путь для сохранения выходных файлов. По умолчанию файлы сохраняются в текущей директории.
- `-p <префикс>`: Указать префикс для имен выходных файлов. По умолчанию префикс отсутствует.
- `-a`: Режим добавления данных в существующие файлы (по умолчанию файлы перезаписываются).
- `-s`: Вывод краткой статистики (количество элементов каждого типа).
- `-f`: Вывод полной статистики (дополнительно минимальное, максимальное значение, сумма и среднее для чисел; длина самой короткой и самой длинной строки для строк).

---

## Примеры запуска

### Базовый запуск
  ```bash
  java -jar TestShift.jar in1.txt in2.txt
  ```
### С режимом добавления и выводом статистики
  ```bash
  java -jar util.jar -a -s in1.txt in2.txt
  ```
Данные будут добавлены в существующие файлы, а в консоль выведена краткая статистика.

### С полной статистикой
  ```bash
  java -jar util.jar -f in1.txt in2.txt
  ```
В консоль будет выведена полная статистика по данным.

---

## Пример входных файлов

### in1.txt
  ```bash
  Lorem ipsum dolor sit amet
  45
  Пример
  3.1415
  consectetur adipiscing
  -0.001
  тестовое задание
  100500
  ```
### in2.txt
  ```bash
  Нормальная форма числа с плавающей запятой
  1.528535047E-25
  Long
  1234567890123456789
  ```
---
## Пример выходных файлов

### integers.txt
  ```bash
  45
  1234567890123456789
  100500
  ```
### floats.txt
  ```bash
  1.528535047E-25
  3.1415
  -0.001
  ```

### strings.txt
  ```bash
  Lorem ipsum dolor sit amet
  Нормальная форма числа с плавающей запятой
  Пример
  Long
  consectetur adipiscing
  тестовое задание
  ```













