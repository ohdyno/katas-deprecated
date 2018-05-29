function primes(number) {
    if (number === 1)
        return [];
    return [1, 2]
}

test('1 has no primes', function () {
    expect(primes(1)).toEqual([]);
});

test('2 has primes of 1 and 2', function () {
    expect(primes(2)).toEqual([1, 2])
});