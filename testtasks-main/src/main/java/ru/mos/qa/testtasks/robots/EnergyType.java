package ru.mos.qa.testtasks.robots;

/**
 * Тип энергии для питания робота
 * Принцип ООП: Enum - инкапсуляция возможных типов энергии
 */
public enum EnergyType {
    ATOMIC,           // Атомная энергия
    COMBUSTION,       // Внутреннее сгорание (дизель, бензин)
    ELECTRIC,         // Электрическая энергия
    HYBRID_ATOMIC_ELECTRIC,      // Гибрид: атомная + электрическая
    HYBRID_COMBUSTION_ELECTRIC   // Гибрид: внутреннее сгорание + электрическая
}
