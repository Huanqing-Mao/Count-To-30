# Count-To-30

Count-To-30 is a lightweight Java desktop game that reenacts the classic counting challenge. Two players—one human, one computer—race toward step 30. Landing on that final step means defeat.

## Gameplay
- The user always moves first and may advance 1 or 2 steps per turn.
- The computer responds immediately, also choosing 1 or 2 steps.
- The player forced to call out step 30 loses; the opponent wins.
- The computer currently selects its moves at random, so a perfect-play strategy is not enforced.

## Running the Game
1. Install a Java Runtime Environment (JRE) 8 or newer.
2. Open a terminal and run:
   ```
   java -jar /Users/Olivia/Desktop/NUS/SoC/Count-To-30/CountTo30/out/artifacts/CountTo30_jar/CountTo30.jar
   ```
3. Interact with the GUI to advance through the steps.

## Project Structure
- `CountTo30/src/` – Java source files (`Main.java`, `CountTo30.java`) and manifest.
- `CountTo30/out/production/` – Compiled `.class` files for local runs.
- `CountTo30/out/artifacts/CountTo30_jar/` – Packaged executable JAR.

## Development Notes
- Built with IntelliJ IDEA; `.iml` and output directories are committed for convenience.
- The randomness can be swapped with a deterministic strategy if you want the computer to play optimally (e.g., always aiming to leave multiples of 3 to the opponent).
- Consider adding tests or logging if you extend the ruleset or port the game to web/mobile targets.
