/*
 * MIT License
 * 
 * Copyright (c) 2020 Fabio Lima
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.f4b6a3.ulid.factory;

import java.security.SecureRandom;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.random.RandomGenerator;

/**
 * An abstract factory for generating ULIDs.
 * 
 * The only method that must be implemented is {@link UlidFactory#create(long)}.
 */
public abstract class UlidFactory {

	protected RandomGenerator randomGenerator;

	/**
	 * Use the default {@link java.security.SecureRandom}.
	 */
	public UlidFactory() {
		this(new SecureRandom()::nextBytes);
	}

	/**
	 * Use a random generator that inherits from {@link RandomGenerator}.
	 * 
	 * @param randomGenerator a {@link RandomGenerator} instance
	 */
	public UlidFactory(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	/**
	 * Returns a UUID.
	 * 
	 * @return a ULID
	 */
	public Ulid create() {
		return create(System.currentTimeMillis());
	}

	/**
	 * Returns a UUID with a specific time.
	 * 
	 * This method must be implemented by all subclasses.
	 * 
	 * @param time a specific time
	 * @return a ULID
	 */
	public abstract Ulid create(final long time);
}
