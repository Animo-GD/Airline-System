/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Moaaz
 */
public class Luggage {
     private float weights;
     private String name;

    public Luggage() {
    }
    
    public Luggage(float weights,String name) {
        this.weights = weights;
        this.name = name;
    }

    public void setweights(float weights) {
        this.weights = weights;
    }

    public float getweights() {
        return this.weights;
    }
    
}
