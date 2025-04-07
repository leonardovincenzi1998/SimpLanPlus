package util;

public class Effect {
	//id dichiarato --> status = 0
	//id inizializzato --> status = 1
	//id usato --> status = 2
	private int status;

	public Effect(boolean initialized) {
		if(initialized)
			this.status = 1;
		else 
			this.status = 0;
	}

	public boolean isLess(Effect e) {
		return this.status < e.status;
	}

	public boolean isMore(Effect e) {
		return this.status > e.status;
	}

	public boolean isInitialized() {
		return status >= 1;
	}

	public boolean isUsed() {
		return status >= 2;
	}

	public void setInitialized() {
		if(this.status < 1)
			this.status = 1;
	}

	public void setUsed() {
		if(this.status < 2)
			this.status = 2;
	}
	
	public void join(Effect effectCopy){
        //DECLARED < INITIALIZED < USED
		final int DECLARED = 0;
		final int INITIALIZED = 1;
		final int USED = 2;
        int effect1 = this.status;
		int effect2 = effectCopy.status;
		int iRet = DECLARED;
        if(effect1 == INITIALIZED && effect2 == INITIALIZED){
            iRet = INITIALIZED;
        }
        else if(effect1 == USED && effect2 == USED){
            iRet = USED;
        }
        else if(effect1 == USED && effect2 !=USED){
            if(effect2==DECLARED){
                iRet = DECLARED;
            }else {
                iRet = USED;
            }
        }
        else if(effect2 == USED && effect1 !=USED){
            if(effect1==DECLARED){
                iRet = DECLARED;
            }else {
                iRet = USED;
            }
        }
        this.status = iRet;
    }

	//metodo non utilizzato
	public Effect getMax(Effect e1, Effect e2){
        if(e1.isMore(e2))
            return e1;
        return e2;
    }

	//metodo non utilizzato
    public Effect getMin(Effect e1, Effect e2){
        if(e1.isLess(e2))
            return e1;
        return e2;
    }
}