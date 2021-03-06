# **Задача 2. Межпоточный диалог со счетчиком**
## Описание
Модифицируйте код для потоков из предыдущей задачи таким образом, чтобы это была Callable-задача, возвращающая кол-во выведенных в консоль сообщений, а цикл выполнения был конечен. Запустите некоторое кол-во этих задач в пул потоков фиксированного количества и получите результаты выполнения задач. Проведите аналогичную операцию, но с получением результата от одной из задач (pool.invokeAny())

## Функционал программы
* Создание 4 потоков, каждый из которых имеет свое имя.
* Каждые 2-3 секунды поток печатает сообщение в консоль. 
* Обязательно в сообщении должно фигурировать имя потока
## Реализация
1. Создайте Callable-задачу, которую будут выполнять потоки.
 2. Задача должна печатать несколько сообщений в консоль и завершаться. 
3. Результатом задачи должно быть количество отправленных сообщений.
Создайте новый пул потоков необходимого размера.
Отправьте на выполнение в пул потоков необходимое количество Callable-объектов.
## *Подсказка*
Используйте ```Callable``` для создания задач, возвращающих результат. Используйте ```Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())``` для создания пула потоков. Используйте методы ```submit()``` или ```invokeAll``` для исполнения всех задач и метод ```invokeAny``` для получения результата одной из них (самой быстрой)