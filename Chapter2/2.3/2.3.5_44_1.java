job.setJarByClass(WordCount.class);
job.set MapperClass(Tokenizer Mapper.class);
job.setCombinerClass(IntSumReducer.class);
job.setReducerClass(IntSumReducer.class);
