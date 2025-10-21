import { defineConfig } from 'vitest/config'

export class Game {
  constructor() { this.player1 = 0; this.player2 = 0; }
  wonPoint(player) { player === "player1" ? this.player1++ : this.player2++; }
  getScore() { return "Love-All"; }
}

export default defineConfig({
  test: {
    include: ["**/*.test.js"], // aquí indicamos explícitamente
    exclude: ["node_modules", "dist"]
  },
})
