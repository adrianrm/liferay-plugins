/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.hook.expando.mongodb.util;

/**
 * @author Raymond Augé
 */
public class MongoDB {

	public class OPS {

		public static final String ADD_TO_SET = "$addToSet";

		public static final String INC = "$inc";

		public static final String POP = "$pop";

		public static final String PULL = "$pull";

		public static final String PULL_ALL = "$pullAll";

		public static final String PUSH = "$push";

		public static final String PUSH_ALL = "$pushAll";

		public static final String RENAME = "$rename";

		public static final String SET = "$set";

		public static final String UNSET = "$unset";

	}

	public class COND {

		public static final String GT = "$gt";

		public static final String GTE = "$gte";

		public static final String LT = "$lt";

		public static final String LTE = "$lte";

		public static final String ALL = "$all";

		public static final String EXISTS = "$exists";

		public static final String MOD = "$mod";

		public static final String NE = "$ne";

		public static final String IN = "$in";

		public static final String NIN = "$NIN";

		public static final String NOR = "$NOR";

		public static final String OR = "$OR";

		public static final String SIZE = "$size";

		public static final String TYPE = "$type";

		public static final String NOT = "$not";

		public static final String WHERE = "$where";

	}

}