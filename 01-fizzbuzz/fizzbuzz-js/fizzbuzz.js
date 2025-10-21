
export const fizzbuzz = (number) => {
    if (typeof number !== 'number') throw new Error('parameter provided must be a number');
    if (Number.isNaN(number)) throw new Error('parameter provided must be a number');

    return number;
}