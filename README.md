# genometools

GenomeTools is a suite of tools to work with genomics data files. 
It makes samtools functionality available from the commandline through java.

Latest jar-with-dependencies is available:

https://artifactory.ewi.tudelft.nl/ui/native/libs-release/be/abeel/genometools/

> [!TIP]
> Use the jar-with-dependencies.


## Usage

The tools in the table below are available for use.
The tool name is given as argument for the tool, 
as described in the [Running](#Running) section below.

|option|description|
|---|---|
|    ambiguity           |Aggregate ambiguity information from VCF files|
|    bam2fraglendistr    |Tool to calculate the fragment length distribution from a BAM file|
|    bam2gc              |Tool to calculate GC histogram|
|    bam2kmer            |Tool to generate subset of kmers and statistics from a BAM file.|
|    bam2readnames       |There is no description available for this tool|
|    bam2tdf             |converts BAM files to TDF (coverage) files. calculates fragment coverage, not physical coverage.|
|    bamstats            |Tool to calculate basic statistics from a BAM file: fragment length distribution, read lenght distribution, read counts.|
|    ena-download        |There is no description available for this tool|
|    extract-duplications|Extract information about large duplications from Pilon runs|
|    faq2gc              |Tool to draw GC statistics from fasta or fastq file.|
|    faq2kmer            |Tool to draw kmer statistics from fasta or fastq file.|
|    faqstats            |Tool to calculate statistics from fasta or fastq file.|
|    gfa-fast-statistics* |Tool to calculate basic statistics from a GFA file .|
|    gfa-statistics   *   |Tool to calculate basic statistics from a GFA file. |
|    groupprofile        |Group profiles from an AP matrix into a list of rows per profile.|
|    inject              |There is no description available for this tool|
|    intersect-kmer      |Tool to reduce kmer file size by filtering by count.|
|    kmer2matrix         |Generate an A/P matrix for a collection of kmer files|
|    list-tree           |List all nodes in the tree in the order they will appear in the figure.|
|    merge-projects      |Merge several projects together.|
|    nwk2list            |There is no description available for this tool|
|    nwk2nodes           |Tool to convert a nwk file to a list of nodes, each including the list of strains under that node.|
|    phy2maf             |Tool to convert phylip to multi-fasta file format.|
|    pilon-metrics       |Program to extract metrics from all Pilon runs|
|    reducekmer          |Tool to reduce kmer file size by filtering by count.|
|    reducevcf           |reducevcf is a tool to reduce the size of VCF files. It will remove all lines where the alternative allele matches the reference allele. In most cases this will reduce the VCF to less than 1% of its original size.|
|    snpmatrix           |Create pairwise SNP distance matrix|
|    snpmatrix-distribution|Create distribution plot from SNP matrix|
|    suspicious   *       |Identify samples that should be excluded based on their CPT, ambiguity rate and large insertion rate.|
|    variant2gene        |Map variants from VCF files to genes or other coordinate based features|
|    vcf-statistics      |There is no description available for this tool|
|    vcf2conserved   *    |    Tool to identify perfectly conserved regions from a set of VCF files.     Currently only works for single chromosome genomes. |
|    vcf2coverage        |There is no description available for this tool|
|    vcf2gc              |There is no description available for this tool|
|    vcf2matrix   *      |Tool to convert a set of VCF files to a mutation matrix |
|    vcf2mfa             |There is no description available for this tool|
|    vcfstats            |There is no description available for this tool|
|    wig2tdf             |Tool to convert WIG to TDF| 
    
> [!WARNING]
> All * marked tools are still in development and is not for general use.



## Running
Start by using:`java -jar genometools-<version>.jar`

Get help using `java -jar genometools-<version>.jar  <option>`

#### example to get help for reducevcf
```
java -jar target/genometools-1.1.0-jar-with-dependencies.jar reducevcf 
```

#### example to get bam stats
```
java -jar genometools-1.1.0-jar-with-dependencies.jar bamstats -i wgs.bam  -o bamstats
```

which results in a bamstats.png picture anda bamstats.txt file.

#### Example bam2tdf
You must have both the wgs.bam and wgs.bam.bai to make this work:

```
java -jar ../genometools-1.1.0-jar-with-dependencies.jar bam2tdf  wgs.bam
```

The result is a wgs.bam.tdf file.

