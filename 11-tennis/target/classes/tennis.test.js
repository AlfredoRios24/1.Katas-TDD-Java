import { describe, it, expect } from "vitest";
import { Game } from "./tennis.js";

describe("Tennis Kata JS", () => {
  it("starts at Love-All", () => {
    const game = new Game();
    expect(game.getScore()).toBe("Love-All");
  });
});
