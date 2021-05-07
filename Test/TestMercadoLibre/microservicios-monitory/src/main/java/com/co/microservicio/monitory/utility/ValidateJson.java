package com.co.microservicio.monitory.utility;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ValidateJson {

	
	public Object jsonArray(String text, String key) throws Exception {
		return jsonValue(text, key, true, null);
	}

	public Object jsonGet(String text, String key) throws Exception {
		return jsonValue(text, key, false, null);
	}

	public Object jsonGetCondition(String text, String key, List<JsonCondition> conditions) throws Exception {
		return jsonValue(text, key, false, conditions);
	}

	public Object jsonGetConditions(String text, String key, List<JsonCondition> conditions) throws Exception {
		return jsonValue(text, key, true, conditions);
	}

	private Object jsonValue(String text, String key, boolean isArray, List<JsonCondition> conditions)
			throws Exception {
		try {
			if (key.contains(".")) {

				text = valueGet(text, key.substring(0, key.indexOf("."))).toString();
				key = key.substring(key.indexOf(".") + 1);

				if (text.charAt(0) == '[') {
					return arrayGet(text, key, isArray, conditions);
				} else {
					return jsonValue(text, key, false, null);
				}
			}
			if (text.charAt(0) == '[') {
				return arrayGet(text, key, false, null);
			}
			return valueGet(text, key);
		} catch (Exception e) {
			return null;
		}
	}

	private Object getKeyCondition(String json, String key) throws Exception {
		Object item = null;
		try {
			item = jsonGet(json, key);

			if (item == null) {
				return getKeyCondition(json, key.substring(key.indexOf(".") + 1));
			}

		} catch (Exception e) {
			throw e;
		}
		return item;
	}

	private boolean validaCondition(String json, List<JsonCondition> conditions) throws Exception {
		for (JsonCondition condition : conditions) {
			Object itemCondition = getKeyCondition(json, condition.getKey());
			if (itemCondition != null) {
				 if (condition.getValue() != null
						&& !itemCondition.toString().contains(condition.getValue())) {
					return false;
				}

			}
		}
		return true;
	}

	private Object arrayGet(String text, String key, boolean isArray, List<JsonCondition> conditions)
			throws Exception {

		Object value = null;

		try {
			JSONArray array = new JSONArray(text);
			JSONArray newArray = new JSONArray();
			
			for (int i = 0; i < array.length(); i++) {
				Object item = jsonGet(array.get(i).toString(), key);
				if (item != null) {
					if (conditions != null) {
						if (validaCondition(array.get(i).toString(), conditions)) {
							newArray.put(item);
							value = item;
							if (!isArray) {
								break;
							}
						}
					} else {
						newArray.put(item);
						value = item;
						if (!isArray) {
							break;
						}
					}
				}
			}
			if (isArray) {
				value = newArray.toString();
			}

		} catch (Exception e) {
			throw e;
		}
		return value;
	}

	private Object valueGet(String text, String key) throws Exception {

		Object value = null;
		try {
			JSONObject json = new JSONObject(text);

			if (json.has(key)) {
				value = json.get(key);
			}

		} catch (JSONException e) {
			throw e;
		}
		return value;
	}

}
