/*
 * This file is generated by jOOQ.
 */
package me.tj3828.jooq.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import me.tj3828.jooq.Indexes;
import me.tj3828.jooq.Keys;
import me.tj3828.jooq.Public;
import me.tj3828.jooq.tables.records.PersonRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Person extends TableImpl<PersonRecord> {

    private static final long serialVersionUID = 1011063576;

    /**
     * The reference instance of <code>PUBLIC.PERSON</code>
     */
    public static final Person PERSON = new Person();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PersonRecord> getRecordType() {
        return PersonRecord.class;
    }

    /**
     * The column <code>PUBLIC.PERSON.ID</code>.
     */
    public final TableField<PersonRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PERSON.EMAIL</code>.
     */
    public final TableField<PersonRecord, String> EMAIL = createField("EMAIL", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PERSON.JOINED</code>.
     */
    public final TableField<PersonRecord, Timestamp> JOINED = createField("JOINED", org.jooq.impl.SQLDataType.TIMESTAMP.precision(6), this, "");

    /**
     * The column <code>PUBLIC.PERSON.NAME</code>.
     */
    public final TableField<PersonRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.PERSON</code> table reference
     */
    public Person() {
        this(DSL.name("PERSON"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.PERSON</code> table reference
     */
    public Person(String alias) {
        this(DSL.name(alias), PERSON);
    }

    /**
     * Create an aliased <code>PUBLIC.PERSON</code> table reference
     */
    public Person(Name alias) {
        this(alias, PERSON);
    }

    private Person(Name alias, Table<PersonRecord> aliased) {
        this(alias, aliased, null);
    }

    private Person(Name alias, Table<PersonRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Person(Table<O> child, ForeignKey<O, PersonRecord> key) {
        super(child, key, PERSON);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_8, Indexes.UK_585QCYC8QH7BG1FWGM1PJ4FUS_INDEX_8);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PersonRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_8;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PersonRecord>> getKeys() {
        return Arrays.<UniqueKey<PersonRecord>>asList(Keys.CONSTRAINT_8, Keys.UK_585QCYC8QH7BG1FWGM1PJ4FUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person as(String alias) {
        return new Person(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person as(Name alias) {
        return new Person(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Person rename(String name) {
        return new Person(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Person rename(Name name) {
        return new Person(name, null);
    }
}