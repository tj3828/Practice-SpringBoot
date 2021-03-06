/*
 * This file is generated by jOOQ.
 */
package me.tj3828.jooq;


import me.tj3828.jooq.tables.Meeting;
import me.tj3828.jooq.tables.Person;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_6 = Indexes0.PRIMARY_KEY_6;
    public static final Index PRIMARY_KEY_8 = Indexes0.PRIMARY_KEY_8;
    public static final Index UK_585QCYC8QH7BG1FWGM1PJ4FUS_INDEX_8 = Indexes0.UK_585QCYC8QH7BG1FWGM1PJ4FUS_INDEX_8;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_6 = Internal.createIndex("PRIMARY_KEY_6", Meeting.MEETING, new OrderField[] { Meeting.MEETING.ID }, true);
        public static Index PRIMARY_KEY_8 = Internal.createIndex("PRIMARY_KEY_8", Person.PERSON, new OrderField[] { Person.PERSON.ID }, true);
        public static Index UK_585QCYC8QH7BG1FWGM1PJ4FUS_INDEX_8 = Internal.createIndex("UK_585QCYC8QH7BG1FWGM1PJ4FUS_INDEX_8", Person.PERSON, new OrderField[] { Person.PERSON.EMAIL }, true);
    }
}
