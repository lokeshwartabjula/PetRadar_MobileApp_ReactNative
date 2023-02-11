import React from 'react';
import { SafeAreaView, StyleSheet, Text } from 'react-native';
import Config from 'react-native-config';

interface Props { }

const App: React.FC<Props> = (props: Props) => {
  return (
    <SafeAreaView style={styles.container}>
      <Text>App.tsx {Config.BASE_URL}</Text>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white'
  }
})

export default App;