package Entity;

import javax.persistence.Embeddable;

@Embeddable
public class ValeurNutritive {
    private String scoreNutritionnel;
    private String energies;
    private String graisses;
    private String sucres;
    private String fibres;
    private String proteines;
    private String sel;
    private String vitA;
    private String vitD;
    private String vitE;
    private String vitK;
    private String vitC;
    private String vitB1;
    private String vitB2;
    private String vitPP;
    private String vitB6;
    private String vitB9;
    private String vitB12;
    private String calcium;
    private String magnesium;
    private String iron;
    private String fer;
    private String betaCarotene;
    private boolean huildeDePalme;

    public ValeurNutritive() {
    }

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public String getEnergies() {
        return energies;
    }

    public void setEnergies(String energies) {
        this.energies = energies;
    }

    public String getGraisses() {
        return graisses;
    }

    public void setGraisses(String graisses) {
        this.graisses = graisses;
    }

    public String getSucres() {
        return sucres;
    }

    public void setSucres(String sucres) {
        this.sucres = sucres;
    }

    public String getFibres() {
        return fibres;
    }

    public void setFibres(String fibres) {
        this.fibres = fibres;
    }

    public String getProteines() {
        return proteines;
    }

    public void setProteines(String proteines) {
        this.proteines = proteines;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getVitA() {
        return vitA;
    }

    public void setVitA(String vitA) {
        this.vitA = vitA;
    }

    public String getVitD() {
        return vitD;
    }

    public void setVitD(String vitD) {
        this.vitD = vitD;
    }

    public String getVitE() {
        return vitE;
    }

    public void setVitE(String vitE) {
        this.vitE = vitE;
    }

    public String getVitK() {
        return vitK;
    }

    public void setVitK(String vitK) {
        this.vitK = vitK;
    }

    public String getVitC() {
        return vitC;
    }

    public void setVitC(String vitC) {
        this.vitC = vitC;
    }

    public String getVitB1() {
        return vitB1;
    }

    public void setVitB1(String vitB1) {
        this.vitB1 = vitB1;
    }

    public String getVitB2() {
        return vitB2;
    }

    public void setVitB2(String vitB2) {
        this.vitB2 = vitB2;
    }

    public String getVitPP() {
        return vitPP;
    }

    public void setVitPP(String vitPP) {
        this.vitPP = vitPP;
    }

    public String getVitB6() {
        return vitB6;
    }

    public void setVitB6(String vitB6) {
        this.vitB6 = vitB6;
    }

    public String getVitB9() {
        return vitB9;
    }

    public void setVitB9(String vitB9) {
        this.vitB9 = vitB9;
    }

    public String getVitB12() {
        return vitB12;
    }

    public void setVitB12(String vitB12) {
        this.vitB12 = vitB12;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(String magnesium) {
        this.magnesium = magnesium;
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getFer() {
        return fer;
    }

    public void setFer(String fer) {
        this.fer = fer;
    }

    public String getBetaCarotene() {
        return betaCarotene;
    }

    public void setBetaCarotene(String betaCarotene) {
        this.betaCarotene = betaCarotene;
    }

    public boolean isHuildeDePalme() {
        return huildeDePalme;
    }

    public void setHuildeDePalme(boolean huildeDePalme) {
        this.huildeDePalme = huildeDePalme;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValeurNutritive{");
        sb.append("scoreNutritionnel='").append(scoreNutritionnel).append('\'');
        sb.append(", energies='").append(energies).append('\'');
        sb.append(", graisses='").append(graisses).append('\'');
        sb.append(", sucres='").append(sucres).append('\'');
        sb.append(", fibres='").append(fibres).append('\'');
        sb.append(", proteines='").append(proteines).append('\'');
        sb.append(", sel='").append(sel).append('\'');
        sb.append(", vitA='").append(vitA).append('\'');
        sb.append(", vitD='").append(vitD).append('\'');
        sb.append(", vitE='").append(vitE).append('\'');
        sb.append(", vitK='").append(vitK).append('\'');
        sb.append(", vitC='").append(vitC).append('\'');
        sb.append(", vitB1='").append(vitB1).append('\'');
        sb.append(", vitB2='").append(vitB2).append('\'');
        sb.append(", vitPP='").append(vitPP).append('\'');
        sb.append(", vitB6='").append(vitB6).append('\'');
        sb.append(", vitB9='").append(vitB9).append('\'');
        sb.append(", vitB12='").append(vitB12).append('\'');
        sb.append(", calcium='").append(calcium).append('\'');
        sb.append(", magnesium='").append(magnesium).append('\'');
        sb.append(", iron='").append(iron).append('\'');
        sb.append(", fer='").append(fer).append('\'');
        sb.append(", betaCarotene='").append(betaCarotene).append('\'');
        sb.append(", huildeDePalme=").append(huildeDePalme);
        sb.append('}');
        return sb.toString();
    }
}
