import React from 'react';
import { SafeAreaView, StyleSheet, Text } from 'react-native';

interface Props { }

const App: React.FC<Props> = (props: Props) => {
  return (
    <SafeAreaView style={styles.container}>
      <Text>App.tsx</Text>
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