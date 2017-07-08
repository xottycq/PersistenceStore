package org.xottys.persistencestore;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BANK_ACCOUNT".
*/
public class BankAccountDao extends AbstractDao<BankAccount, Long> {

    public static final String TABLENAME = "BANK_ACCOUNT";

    /**
     * Properties of entity BankAccount.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property AccountNumber = new Property(2, String.class, "accountNumber", false, "ACCOUNT_NUMBER");
        public final static Property Balance = new Property(3, int.class, "balance", false, "BALANCE");
    }


    public BankAccountDao(DaoConfig config) {
        super(config);
    }
    
    public BankAccountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BANK_ACCOUNT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"ACCOUNT_NUMBER\" TEXT," + // 2: accountNumber
                "\"BALANCE\" INTEGER NOT NULL );"); // 3: balance
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BANK_ACCOUNT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BankAccount entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String accountNumber = entity.getAccountNumber();
        if (accountNumber != null) {
            stmt.bindString(3, accountNumber);
        }
        stmt.bindLong(4, entity.getBalance());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BankAccount entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String accountNumber = entity.getAccountNumber();
        if (accountNumber != null) {
            stmt.bindString(3, accountNumber);
        }
        stmt.bindLong(4, entity.getBalance());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BankAccount readEntity(Cursor cursor, int offset) {
        BankAccount entity = new BankAccount( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // accountNumber
            cursor.getInt(offset + 3) // balance
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BankAccount entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAccountNumber(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBalance(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BankAccount entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BankAccount entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BankAccount entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
