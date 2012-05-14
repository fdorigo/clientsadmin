package com.fdorigo.igadmin.persistent;

import com.fdorigo.igadmin.persistent.auto._IlluminateDomainMap;

public class IlluminateDomainMap extends _IlluminateDomainMap {

    private static IlluminateDomainMap instance;

    private IlluminateDomainMap() {}

    public static IlluminateDomainMap getInstance() {
        if(instance == null) {
            instance = new IlluminateDomainMap();
        }

        return instance;
    }
}
