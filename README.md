# Virtual Ecosystem Simulation 🌿🦁

A comprehensive object-oriented simulation in Java that models the dynamic interaction and survival behaviors of various organisms (Plants, Herbivores, and Carnivores) within a bounded 2D grid environment over a series of simulated days.

---

## 📋 Overview

The **Virtual Ecosystem Simulation** models an ecosystem where organisms interact daily based on energy levels, movement rules, and predator-prey dynamics:
* **Plants (P)**: Primary producers that regenerate energy daily and remain stationary.
* **Herbivores (H)**: Consumers that feed on plants to replenish energy, moving across the grid each day.
* **Carnivores (C)**: Predators that hunt herbivores for energy and navigate the board to survive.

Organisms move across the board, consume resources, lose energy through movement, and perish when their energy drops to zero.

---

## 🛠️ Architecture & Class Structure

The project strictly follows Object-Oriented Programming (OOP) principles, utilizing abstraction, inheritance, interfaces, and encapsulation:

| Class / Interface | Type | Role & Responsibility |
| :--- | :--- | :--- |
| `Organism` | Abstract Class | Base class for all entities, holding `id`, `location`, `energy`, and `name`. Defines abstract `daily_movement()`. |
| `Animal` | Abstract Class | Extends `Organism` and implements `I_AnimalAction`. Manages movement logic, direction checks, and feeding mechanisms. |
| `Plant` | Class | Extends `Organism`. Static entity that increases energy daily (`+10`). |
| `Herbivore` | Class | Extends `Animal`. Consumes `Plant` entities; loses 10 energy per movement step. |
| `Carnivore` | Class | Extends `Animal`. Consumes `Herbivore` entities; loses 15 energy per movement step. |
| `I_AnimalAction` | Interface | Contract for animal behaviors (`eat`, `move`). |
| `Board` | Class | Manages the 2D grid representation (`Organism[][]`), placement, validation, and board rendering. |
| `Simulator` | Class | Orchestrates the day-by-day execution loop of the ecosystem simulation. |
| `Main` | Class | Program entry point that initializes and launches the simulation. |

---

## ⚙️ How the Simulation Works

1. **Initialization**: The `Board` is populated with a specified number of Carnivores, Herbivores, and Plants at random valid coordinates.
2. **Daily Execution Cycle**:
   * **Energy & Survival Check**: If an organism's energy reaches `0` or below, it is removed from the board.
   * **Feeding Phase (`eat`)**: Animals check adjacent grid spaces for valid prey (`Carnivore` -> `Herbivore`, `Herbivore` -> `Plant`). Upon eating, energy is replenished by the consumed entity's energy value.
   * **Movement Phase (`move`)**: If no food is eaten, animals attempt to move to a neighboring empty space while consuming movement energy.
3. **Board Rendering**: At the end of each simulated day, the grid state is printed to the standard output console.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK 11 or higher)
* Visual Studio Code (with *Extension Pack for Java*) or any Java IDE

### Running the Project

1. **Clone the Repository**:
```bash
git clone https://github.com/ayalabd1/VirtualEcosystemSimulation-OOP.git
cd VirtualEcosystemSimulation-OOP
```

2. **Compile the Java Sources**:
```bash
javac -d bin src/*.java
```

3. **Execute the Simulation**:
```bash
java -cp bin src.Main
```

---

## 💻 Sample Console Output

```text
Starting board state:
0 C 0 
H 0 P 
0 0 0 

Day 1:
0 C 0 
0 0 P 
0 0 0 

Day 2:
0 0 C 
0 0 P 
0 0 0 
```

---

## 📄 License
This project was developed for academic learning in Object-Oriented Programming (OOP) concepts in Java.