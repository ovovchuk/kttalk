package com.itrally


interface Repository<T> {
    fun findById(id: Int): T?
    fun findAll(): List<T>
    fun save(entity: T): Boolean
    fun saveAll(entities: List<T>): Boolean
}

interface PersonRepository : Repository<Person> {
    private val persons: MutableCollection<Person>
        get() = mutableListOf()

    val isEmpty: Boolean
        get() = persons.isEmpty()

    override fun findAll() = persons.toList()

    fun findByFirstName(firstName: String): List<Person>

    fun findByLastName(lastName: String): List<Person>

    override fun save(entity: Person) = persons.add(entity)

    override fun saveAll(entities: List<Person>) = this.persons.addAll(entities)
}

class PersonRepositoryImpl : PersonRepository {
    override fun findById(id: Int): Person? = findAll().find { it.id == id }

    override fun findByFirstName(firstName: String) = findAll().filter { it.firstName == firstName }

    override fun findByLastName(lastName: String) = findAll().filter { it.lastName == lastName }
}

open class BaseClass(val prop: String)

class OtherClass : BaseClass("")