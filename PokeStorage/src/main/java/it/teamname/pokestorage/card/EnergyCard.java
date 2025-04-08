package it.teamname.pokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergyCard {

    public String category;
    public String effect;
    public String energyType;

}
