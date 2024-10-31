package domain;

import java.util.Date;

public class Matricula {

    protected Integer Codigo;
    protected Date DataMat;

    
    public Matricula(Date dataMat) {
        DataMat = dataMat;
    }

    public Integer getCodigo() {
        return Codigo;
    }
    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }
    public Date getDataMat() {
        return DataMat;
    }
    public void setDataMat(Date dataMat) {
        DataMat = dataMat;
    }

    
    
}
