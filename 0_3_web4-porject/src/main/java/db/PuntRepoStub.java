package db;

import domain.Punt;

import java.util.ArrayList;
import java.util.HashMap;

public class PuntRepoStub {

    private HashMap<Integer,Punt> map;

    public PuntRepoStub(){
        map = new HashMap<Integer, Punt>();
    }

    public void add(Punt p){
        p.setId(map.size());
        map.put(p.getId(),p);
    }

    public ArrayList<Punt> getPunten() {
        return new ArrayList<>(map.values());
    }
}
