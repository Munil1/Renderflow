package com.byabie.rdf.lib.xtml;

import java.util.Arrays;
import java.util.HashMap;

import com.byabie.rdf.lib.Annotation;
import com.byabie.rdf.lib.Type;

public class XTMLContent {
	public class Symbol {
		public Type type;
		public Object value;
		public Symbol(Type type, @Annotation.NotNull Object value) {
			this.type = type;
			this.value = value;
		}
	}
	public class Json {
		private final HashMap<String, Symbol> properties;
		public Json(HashMap<String, Symbol> properties) {
			this.properties = properties;
		}
		public Symbol get(String key) {
			return properties.get(key);
		}
		public Symbol get(String... keys) {
            if (keys.length == 0) {
                return null;
            }

            Symbol returns = properties.get(keys[0]);

            for (int i = 1; i < keys.length; i++) {
                try {
                    Json t_value = (Json) returns.value; 
                    returns = t_value.get(keys[i]);
                } catch (ClassCastException exc) {
                    throw new IllegalArgumentException("Property '" + keys[i] + "' is not a JSON object in the path: " + Arrays.toString(keys));
                }
            }
            return returns;
        }
	}
	public class Xml {
		public Tag root;
		public class Tag {
			public String id;
			public Tag[] contains;
			public Attribute[] attributes;
			public class Attribute {
				public String name;
				public Object value;
				public Attribute(String name, Object value) {
					this.name = name;
					this.value = value;
				}
			}
		}
		public class EmptyTag extends Tag {}
	}
}