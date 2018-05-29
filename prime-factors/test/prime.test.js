function primes(number) {
    let factors = [];

    if (1 < number)
        factors.push(2);

    return factors
}

test('1 has no primes', function () {
    expect(primes(1)).toEqual([]);
});

test('2 has primes of 2', function () {
    expect(primes(2)).toEqual([2])
});