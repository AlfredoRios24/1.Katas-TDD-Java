import { describe, it, expect } from "vitest";
import { fizzbuzz } from "./fizzbuzz.js";

describe('fizzbuzz', () => {
    it('should be a function', () => {
        expect(typeof fizzbuzz).toBe('function');
    });
});