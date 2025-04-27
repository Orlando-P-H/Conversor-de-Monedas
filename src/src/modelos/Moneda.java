package modelos;

import com.google.gson.annotations.SerializedName;

public class Moneda {

    @SerializedName("base_code")
    private String baseCurrency;
    @SerializedName("target_code")
    private String targetCurrency;
    @SerializedName("conversion_rate")
    private float conversionRate;

    private float conversion;

    public Moneda(String baseCurrency, String targetCurrency, float conversionRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.conversionRate = conversionRate;
    }

    //Getter y Setters.

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public float getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(float conversionRate) {
        this.conversionRate = conversionRate;
    }

    public float getConversion() {
        return conversion;
    }

    public void setConversion(float conversion) {
        this.conversion = conversion;
    }

    //Metodo para hacer la conversión.

    public float Conversion(float cantidad)
    {
        float resultado = conversionRate * cantidad;
        return resultado;
    }
}
