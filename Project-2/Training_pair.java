package application;

//Bundling class for input-output
//pairs
class Training_pair{
	private String input_vals;
	private String keys;

	public Training_pair(String i_v, String k)
	{
		input_vals = i_v;
		keys = k;
	}

	//Getter
	public String get_vals()
	{
		return input_vals;
	}

	public String get_keys()
	{
		return keys;
	}

	//Setter
	public void set_vals(String i_v)
	{
		input_vals = i_v;
	}

	public void set_keys(String k)
	{
		keys = k;
	}
}

