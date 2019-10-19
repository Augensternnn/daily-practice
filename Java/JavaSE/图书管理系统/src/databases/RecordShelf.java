package databases;

import classes.Record;
import classes.User;
import exception.NotBorrowedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordShelf {
    List<Record> recordList = new ArrayList<>();

    private static RecordShelf instance = new RecordShelf();
    public static RecordShelf getInstance() {
        return instance;
    }

    public boolean contains(User user, String ISBN) {
        for(Record record : recordList){
            if(record.is(user, ISBN)){
                return true;
            }
        }
        return false;
    }

    public void putRecord(User user, String ISBN) {
        Record record = new Record(user.getId(), ISBN);
        recordList.add(record);
    }

    public List<Record> queryRecords(Where<Record> where) {
        List<Record> ret = new ArrayList<>();
        for(Record record : recordList){
            if(where.test(record)){
                ret.add(record);
            }
        }
        return ret;
    }

    public void remove(User user, String ISBN) throws NotBorrowedException {
        Iterator<Record> iterator = recordList.iterator();
        while (iterator.hasNext()){
            Record record = iterator.next();
            if(record.is(user, ISBN)){
                iterator.remove();
                return;
            }
        }
        throw new NotBorrowedException();
        /*
        int index = -1;
        for(int i = 0; i < recordList.size(); i++){
            Record record = recordList.get(i);
            if (record.is(user, ISBN)){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new NotBorrowedException();
        }
        recordList.remove(index);
         */
    }
}
