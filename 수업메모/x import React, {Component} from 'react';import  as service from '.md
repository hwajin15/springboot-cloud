```
import React, {Component} from 'react';
import * as service from '../../util/Service';
 
 
class Detail extends Component {
 
     constructor(props) {
        super();
        // initializes component state
        this.state = {
            id: 1,
            seouldatadb: {
                location: null,
                category: null
            }
        };
    }



    fetchPostInfo = async (id) => {
        this.setState({
            fetching: true // requesting..
        });
 
        try {
            // wait for two promises
            const info = await Promise.all([
                service.getPost(id),
               
            ]);
 
            // Object destructuring Syntax,
            // takes out required values and create references to them
            const {location, category } = info[0].data; 
                                                
        
            this.setState({
               id,
               seouldatadb: {
                    location,
                    category
                     
                },
              
            });
 
        } catch(e) {
            // if err, stop at this point
            this.setState({
                fetching: false
            });
            this.showWarning();
        }
    }



 
    render() {
        const {id, seouldatadb } = this.state;
        
        return (
           
              
                <div>
                    id={id},
                    location={seouldatadb.location},
                    category={seouldatadb.category}
                  
                    </div>
                
            
        );
    }
 
}
 
export default Detail;
```





import axios from 'axios';

 

export function getPost(id) {

  return axios.get('http://localhost:8013/seouldatadb/' + id);

}