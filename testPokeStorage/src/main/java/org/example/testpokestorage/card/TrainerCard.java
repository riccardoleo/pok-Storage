package org.example.testpokestorage.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerCard extends Card {

    public String category;
    public String effect;
    public String trainerType;

}
