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

package com.github.f4b6a3.ulid;

import java.util.UUID;

import com.github.f4b6a3.ulid.creator.UlidSpecCreator;
import com.github.f4b6a3.ulid.exception.InvalidUlidException;
import com.github.f4b6a3.ulid.util.UlidConverter;

/**
 * A factory for Universally Unique Lexicographically Sortable Identifiers.
 * 
 * See the ULID spec: https://github.com/ulid/spec
 */
public final class UlidCreator {

	private UlidCreator() {
	}

	/**
	 * Returns a ULID as GUID from a string.
	 * 
	 * The input string must be encoded to Crockford's base32, following the ULID
	 * specification.
	 * 
	 * An exception is thrown if the ULID string is invalid.
	 * 
	 * @param ulid a ULID string
	 * @return a UUID
	 * @throws InvalidUlidException if invalid
	 */
	public static UUID fromString(String ulid) {
		return UlidConverter.fromString(ulid);
	}

	/**
	 * Convert a UUID to ULID string
	 * 
	 * The returning string is encoded to Crockford's base32.
	 * 
	 * @param uuid a UUID
	 * @return a ULID string
	 */
	public static String toString(UUID ulid) {
		return UlidConverter.toString(ulid);
	}

	/**
	 * Returns a ULID as GUID.
	 * 
	 * The random component is generated by a secure random number generator:
	 * {@link java.security.SecureRandom}.
	 * 
	 * @return a UUID
	 */
	public static UUID getUlid() {
		return UlidSpecCreatorHolder.INSTANCE.create();
	}

	/**
	 * Returns a ULID string.
	 * 
	 * The returning string is encoded to Crockford's base32.
	 * 
	 * The random component is generated by a secure random number generator:
	 * {@link java.security.SecureRandom}.
	 * 
	 * @return a ULID string
	 */
	public static String getUlidString() {
		return UlidSpecCreatorHolder.INSTANCE.createString();
	}

	/**
	 * Return a GUID creator for direct use.
	 * 
	 * @return a {@link UlidSpecCreator}
	 */
	public static UlidSpecCreator getUlidSpecCreator() {
		return new UlidSpecCreator();
	}

	private static class UlidSpecCreatorHolder {
		static final UlidSpecCreator INSTANCE = getUlidSpecCreator();
	}
}
