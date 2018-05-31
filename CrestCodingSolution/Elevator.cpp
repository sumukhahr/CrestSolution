#include <iostream>
#include<map>
#include<vector>
#include<ctime>
#include<algorithm>

using namespace std;

int count_stops(map<string, vector<int>> ppl, int size)
	{
		int lift_weight=0;
		int stops=0;
		auto iter=ppl.begin();
		vector<int> stop_list;
		int stop_count=0;
		while(size)
		{
			lift_weight+=iter->second[0];
			if ( stop_list.empty() || find(stop_list.begin(), stop_list.end(), iter->second[1]) == stop_list.end() )
			{
				stop_list.push_back(iter->second[1]);
				cout<<iter->second[1]<<endl;
				stops++;

			}

			if(lift_weight<=200)
			{
				iter = ppl.erase(iter);
			}
			else if(lift_weight > 200)
			{
				lift_weight-=iter->second[0];
				stops++;
				cout<<stop_count<<endl;
				//stops=0;
				stop_count++;
				stop_list.clear();
			}

			size--;
		}

		return stops+2;
	}



	int main()
	{
		srand(time(NULL));
		map<string, vector<int>> ppl;
		int size=5;
		cout<<"Enter the number of persons getting inside elevator :"<<endl;
		cin>>size;
		cout<<"Enter the weight of person and floor to drop off in the format 100 2:"<<endl;
		for(int i=0; i<size; i++)
		{
			string str = "p"+to_string(i);
			int weight,floor;
			cin>>weight;
			cin>>floor;
			ppl[str].push_back(weight);
			ppl[str].push_back(floor);

		}

		for(auto it=ppl.begin(); it!=ppl.end(); it++)
		{
			cout<<it->first<<" "<<it->second[0]<<" "<<it->second[1]<<endl;
		}

		cout<<"*********************************************************"<<endl;


		cout<< "The total number of stops taken are :"<< count_stops(ppl, size) <<endl;
		


		for(auto it=ppl.begin(); it!=ppl.end(); it++)
		{
			cout<<it->first<<" "<<it->second[0]<<" "<<it->second[1]<<endl;
			
		}

		return 0;
	}
