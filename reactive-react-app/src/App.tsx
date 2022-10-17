import { useEffect, useState } from 'react';
import './App.css';
import { interval } from 'rxjs';
import { startWith, switchMap } from 'rxjs/operators';


interface State {
  messages: Array<any>,
  isLoading: boolean
}

const App = () => {

  const [state, setState] = useState<State>({ messages: [], isLoading: false });

  useEffect(() => {

    setState({ messages: [], isLoading: true });

    const request = interval(1000).pipe(
      startWith(0),
      switchMap(() =>
        fetch('http://localhost:9191/router/chat/stream')
          .then((response) => response.json())
      ));

    request.subscribe((data: Array<any>) => {
      setState({ messages: data, isLoading: false });
    });

  }, [])


  const { messages, isLoading } = state;

  if (isLoading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="App">
      {messages.map((message: any) =>
        <div key={`${message.messageSeq}_${message.chatId}`}>
          {message.messageText}<br />
        </div>
      )}
    </div>
  );
}

export default App;
