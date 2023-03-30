@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

/**
 * Класс "Телефонная книга".
 *
 * Общая сложность задания -- средняя, общая ценность в баллах -- 14.
 * Объект класса хранит список людей и номеров их телефонов,
 * при чём у каждого человека может быть более одного номера телефона.
 * Человек задаётся строкой вида "Фамилия Имя".
 * Телефон задаётся строкой из цифр, +, *, #, -.
 * Поддерживаемые методы: добавление / удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class PhoneBook {
    class Person(val name: String, val phoneNums: MutableList<String>) {
        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + phoneNums.hashCode()
            return result
        }
    }

    val phoneBook = mutableListOf<Person>()

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun addHuman(name: String): Boolean {
        return if (name.matches(Regex("^[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+\$"))) {
            if (phoneBook.any { it.name == name }) false
            else {
                phoneBook.add(Person(name, mutableListOf()))
                phoneBook.sortBy { it.name }
                true
            }
        } else return false
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean {
        val foundPerson = phoneBook.find { it.name == name }

        return if (foundPerson != null) {
            phoneBook.remove(foundPerson)
            true
        } else false
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        val foundPerson = phoneBook.find { it.name == name }

        return if (foundPerson != null) {
            return if (phone.matches(Regex("[+*#\\d-]+"))) {
                if (phoneBook.any { it.phoneNums.any { it == phone } }) false
                else {
                    foundPerson.phoneNums.add(phone)
                    foundPerson.phoneNums.sort()
                    true
                }
            } else false
        } else false
    }

    /**
     * Убрать номер телефона.
     * Возвращает true, если номер был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * либо у него не было такого номера телефона.
     */
    fun removePhone(name: String, phone: String): Boolean {
        val foundPerson = phoneBook.find { it.name == name }

        return if (foundPerson != null) {
            if (foundPerson.phoneNums.any { it == phone }) {
                foundPerson.phoneNums.remove(phone)
                true
            } else false
        } else false
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String> {
        val foundPerson = phoneBook.find { it.name == name }

        return if (foundPerson != null) {
            foundPerson.phoneNums.toSet()
        } else setOf()
    }

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? {
        val foundPhone = phoneBook.find { it.phoneNums.any { it == phone } }

        return if (foundPhone != null) foundPhone.name
        else null
    }

    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneBook) return false
        if (phoneBook.size != other.phoneBook.size) return false

        for (i in phoneBook.indices) {
            if (this.phoneBook[i].name != other.phoneBook[i].name ||
                this.phoneBook[i].phoneNums.size != other.phoneBook[i].phoneNums.size)
                return false

            if (this.phoneBook[i].phoneNums != other.phoneBook[i].phoneNums) return false
        }
        return true
    }

    override fun hashCode(): Int {
        return phoneBook.hashCode()
    }
}